package com.example.practica_1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practica_1.models.negociacao;
import com.example.practica_1.repositories.negociacaoClienteRepository;

@Service
public class negociacaoClienteService {
    private negociacaoClienteRepository negociacaoClienteRepository;

    public negociacaoClienteService(negociacaoClienteRepository negociacaoClienteRepository) {
        this.negociacaoClienteRepository = negociacaoClienteRepository;
    }

    public List<negociacao> getAllContasByClienteId(Long clienteId) {
        return negociacaoClienteRepository.findAllByClienteId(clienteId);
    }

    public negociacao getContaByIdAndClienteId(Long id, Long clienteId) {
        return negociacaoClienteRepository.findByIdAndClienteId(id, clienteId);
    }

    public negociacao createConta(negociacao conta) {
        return negociacaoClienteRepository.guardar(conta);
    }

    public negociacao updateConta(negociacao conta) {
        return negociacaoClienteRepository.actualizar(conta);
    }

    public void deleteConta(Long id, Long clienteId) {
        negociacaoClienteRepository.eliminar(id);
    }
}
