package com.example.practica_1.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practica_1.models.endereco;
import com.example.practica_1.services.enderecoClienteService;

@RestController
@RequestMapping("/api/v1/clientes/{clienteId}/enderecos")
public class enderecoClienteController {
     private enderecoClienteService enderecoClienteService;

    public enderecoClienteController(com.example.practica_1.services.enderecoClienteService enderecoClienteService) {
        this.enderecoClienteService = enderecoClienteService;
    }

    @GetMapping
    public ResponseEntity<List<endereco>> getContas(@PathVariable Long clienteId) {
        return ResponseEntity.ok(enderecoClienteService.getAllContasByClienteId(clienteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<endereco> getConta(@PathVariable Long clienteId, @PathVariable Long id) {
        endereco conta = enderecoClienteService.getContaByIdAndClienteId(id, clienteId);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<endereco> addConta(@PathVariable Long clienteId, @RequestBody endereco conta) {
        conta.setId_cliente(clienteId); // Asigna el cliente a la cuenta
        return ResponseEntity.ok(enderecoClienteService.createConta(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<endereco> updateConta(@PathVariable Long clienteId, @PathVariable Long id, @RequestBody endereco conta) {
        conta.setIdendereco(id);
        conta.setId_cliente(clienteId); // Asegúrate de que la cuenta esté vinculada al cliente
        return ResponseEntity.ok(enderecoClienteService.updateConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long clienteId, @PathVariable Long id) {
        enderecoClienteService.deleteConta(id, clienteId);
        return ResponseEntity.noContent().build();
    }
}
