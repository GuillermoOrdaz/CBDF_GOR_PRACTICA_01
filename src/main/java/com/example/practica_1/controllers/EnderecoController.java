package com.example.practica_1.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practica_1.models.endereco;
import com.example.practica_1.services.EnderecoService;

@RestController
@RequestMapping("/api/v1/enderecos")
public class EnderecoController {
    EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<endereco>> getEndereco(){
        return ResponseEntity.ok(enderecoService.getAllEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<endereco> getEndereco(@PathVariable Long id){
        return ResponseEntity.ok(enderecoService.getEnderecoById(id));
    }

    @PostMapping
    public ResponseEntity<endereco> addEndereco(@RequestBody endereco endereco){
        return ResponseEntity.ok(enderecoService.createEndereco(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<endereco> updateEndereco(@RequestBody endereco endereco, @PathVariable Long id){
        endereco.setIdendereco(id);
        return ResponseEntity.ok(enderecoService.updateEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<endereco> deleteEndereco(@RequestBody endereco endereco, @PathVariable Long id){
        enderecoService.deleleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
