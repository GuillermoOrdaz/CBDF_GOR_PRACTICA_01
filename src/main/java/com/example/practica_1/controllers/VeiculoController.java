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
import com.example.practica_1.services.VeiculoService;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {
    VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<veiculo>> getVeiculos(){
        return ResponseEntity.ok(veiculoService.getAllVeiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<veiculo> getVeiculo(@PathVariable Long id){
        return ResponseEntity.ok(veiculoService.getVeiculoById(id));
    }

    @PostMapping
    public ResponseEntity<veiculo> addVeiculo(@RequestBody veiculo veiculo){
        return ResponseEntity.ok(veiculoService.createVeiculo(veiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<veiculo> updateVeiculo(@RequestBody veiculo veiculo, @PathVariable Long id){
        veiculo.setId(id);
        return ResponseEntity.ok(veiculoService.updateVeiculo(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<veiculo> deleteVeiculo(@RequestBody veiculo veiculo, @PathVariable Long id){
        veiculoService.deleleteVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
