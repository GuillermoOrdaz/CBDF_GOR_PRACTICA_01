package com.example.practica_1.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practica_1.models.negociacao;
import com.example.practica_1.services.NegociacaoService;

@RestController
@RequestMapping("/api/v1/negociacaos")
public class NegociacaoController {
    NegociacaoService negociacaoService;

    public NegociacaoController(NegociacaoService negociacaoService) {
        this.negociacaoService = negociacaoService;
    }

    @GetMapping
    public ResponseEntity<List<negociacao>> getNegociacao(){
        return ResponseEntity.ok(negociacaoService.getAllNegociacaos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<negociacao> getNegociacao(@PathVariable Long id){
        return ResponseEntity.ok(negociacaoService.getNegociacaoById(id));
    }

    @PostMapping
    public ResponseEntity<negociacao> addNegociacao(@RequestBody negociacao negociacao){
        return ResponseEntity.ok(negociacaoService.createNegociacao(negociacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<negociacao> updateNegociacao(@RequestBody negociacao negociacao, @PathVariable Long id){
        negociacao.setId(id);
        return ResponseEntity.ok(negociacaoService.updateNegociacao(negociacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<negociacao> deleteNegociacao(@RequestBody negociacao negociacao, @PathVariable Long id){
        negociacaoService.deleleteNegociacao(id);
        return ResponseEntity.noContent().build();
    }
}
