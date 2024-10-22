package com.example.practica_1.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practica_1.models.cliente;
import com.example.practica_1.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<cliente>> getClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<cliente> getCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @PostMapping
    public ResponseEntity<cliente> addCliente(@RequestBody cliente cliente){
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<cliente> updateCliente(@RequestBody cliente cliente, @PathVariable Long id){
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.updateCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<cliente> deleteCliente(@RequestBody cliente cliente, @PathVariable Long id){
        clienteService.deleleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
