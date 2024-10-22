package com.example.practica_1.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.practica_1.models.negociacao;
import com.example.practica_1.services.negociacaoClienteService;

@RestController
@RequestMapping("/api/v1/clientes/{clienteId}/negociacaos")
public class negociacaoClienteController {
     private negociacaoClienteService negociacaoClienteService;

    public negociacaoClienteController(negociacaoClienteService negociacaoClienteService) {
        this.negociacaoClienteService = negociacaoClienteService;
    }

    @GetMapping
    public ResponseEntity<List<negociacao>> getContas(@PathVariable Long clienteId) {
        return ResponseEntity.ok(negociacaoClienteService.getAllContasByClienteId(clienteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<negociacao> getConta(@PathVariable Long clienteId, @PathVariable Long id) {
        negociacao conta = negociacaoClienteService.getContaByIdAndClienteId(id, clienteId);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<negociacao> addConta(@PathVariable Long clienteId, @RequestBody negociacao conta) {
        conta.setId_cliente(clienteId); // Asigna el cliente a la cuenta
        return ResponseEntity.ok(negociacaoClienteService.createConta(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<negociacao> updateConta(@PathVariable Long clienteId, @PathVariable Long id, @RequestBody negociacao conta) {
        conta.setId(id);
        conta.setId_cliente(clienteId); // Asegúrate de que la cuenta esté vinculada al cliente
        return ResponseEntity.ok(negociacaoClienteService.updateConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long clienteId, @PathVariable Long id) {
        negociacaoClienteService.deleteConta(id, clienteId);
        return ResponseEntity.noContent().build();
    }
}
