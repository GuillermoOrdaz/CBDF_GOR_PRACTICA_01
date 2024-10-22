package com.example.practica_1.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practica_1.models.Conta;
import com.example.practica_1.services.ContaService;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {
    ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getContas(){
        return ResponseEntity.ok(contaService.getAllContas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContae(@PathVariable Long id){
        return ResponseEntity.ok(contaService.getContaById(id));
    }

    @PostMapping
    public ResponseEntity<Conta> addConta(@RequestBody Conta conta){
        return ResponseEntity.ok(contaService.createConta(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@RequestBody Conta conta, @PathVariable Long id){
        conta.setId(id);
        return ResponseEntity.ok(contaService.updateConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> deleteConta(@RequestBody Conta conta, @PathVariable Long id){
        contaService.deleleteConta(id);
        return ResponseEntity.noContent().build();
    }
}
