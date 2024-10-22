package com.example.practica_1.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.practica_1.models.veiculo;
import com.example.practica_1.repositories.veiculoClienteRepository;

@Repository
public class veiculoClienteService {
    private veiculoClienteRepository veiculoClienteRepository;

    public veiculoClienteService(veiculoClienteRepository veiculoClienteRepository) {
        this.veiculoClienteRepository = veiculoClienteRepository;
    }

    public List<veiculo> getAllContasByClienteId(Long clienteId) {
        return veiculoClienteRepository.findAllByClienteId(clienteId);
    }

    public veiculo getContaByIdAndClienteId(Long id, Long clienteId) {
        return veiculoClienteRepository.findByIdAndClienteId(id, clienteId);
    }

    public veiculo createConta(veiculo conta) {
        return veiculoClienteRepository.guardar(conta);
    }

    public veiculo updateConta(veiculo conta) {
        return veiculoClienteRepository.actualizar(conta);
    }

    public void deleteConta(Long id, Long clienteId) {
        veiculoClienteRepository.eliminar(id);
    }
}
