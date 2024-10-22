package com.example.practica_1.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.practica_1.models.Conta;
import com.example.practica_1.services.contaClienteService;

@RestController
@RequestMapping("/api/v1/clientes/{clienteId}/contas")
public class contaClienteController {
    private contaClienteService contaClienteService;
    
     public contaClienteController(contaClienteService contaClienteService) {
        this.contaClienteService = contaClienteService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getContas(@PathVariable Long clienteId) {
        return ResponseEntity.ok(contaClienteService.getAllContasByClienteId(clienteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getConta(@PathVariable Long clienteId, @PathVariable Long id) {
        Conta conta = contaClienteService.getContaByIdAndClienteId(id, clienteId);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Conta> addConta(@PathVariable Long clienteId, @RequestBody Conta conta) {
        conta.setId_cliente(clienteId); // Asigna el cliente a la cuenta
        return ResponseEntity.ok(contaClienteService.createConta(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long clienteId, @PathVariable Long id, @RequestBody Conta conta) {
        conta.setId(id);
        conta.setId_cliente(clienteId); // Asegúrate de que la cuenta esté vinculada al cliente
        return ResponseEntity.ok(contaClienteService.updateConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long clienteId, @PathVariable Long id) {
        contaClienteService.deleteConta(id, clienteId);
        return ResponseEntity.noContent().build();
    }
}
