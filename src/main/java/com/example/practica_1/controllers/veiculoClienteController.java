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
import com.example.practica_1.models.veiculo;
import com.example.practica_1.services.veiculoClienteService;

@RestController
@RequestMapping("/api/v1/clientes/{clienteId}/veiculos")
public class veiculoClienteController {
     private veiculoClienteService veiculoClienteService;

    public veiculoClienteController(veiculoClienteService veiculoClienteService) {
        this.veiculoClienteService = veiculoClienteService;
    }

    @GetMapping
    public ResponseEntity<List<veiculo>> getContas(@PathVariable Long clienteId) {
        return ResponseEntity.ok(veiculoClienteService.getAllContasByClienteId(clienteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<veiculo> getConta(@PathVariable Long clienteId, @PathVariable Long id) {
        veiculo conta = veiculoClienteService.getContaByIdAndClienteId(id, clienteId);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<veiculo> addConta(@PathVariable Long clienteId, @RequestBody veiculo conta) {
        conta.setId_cliente(clienteId); // Asigna el cliente a la cuenta
        return ResponseEntity.ok(veiculoClienteService.createConta(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<veiculo> updateConta(@PathVariable Long clienteId, @PathVariable Long id, @RequestBody veiculo conta) {
        conta.setId(id);
        conta.setId_cliente(clienteId); // Asegúrate de que la cuenta esté vinculada al cliente
        return ResponseEntity.ok(veiculoClienteService.updateConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long clienteId, @PathVariable Long id) {
        veiculoClienteService.deleteConta(id, clienteId);
        return ResponseEntity.noContent().build();
    }
}
