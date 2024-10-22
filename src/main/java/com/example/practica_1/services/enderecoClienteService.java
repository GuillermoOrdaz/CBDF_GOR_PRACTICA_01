package com.example.practica_1.services;

import com.example.practica_1.models.endereco;
import com.example.practica_1.repositories.enderecoClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class enderecoClienteService {
    private enderecoClienteRepository enderecoClienteRepository;

    public enderecoClienteService(enderecoClienteRepository enderecoClienteRepository) {
        this.enderecoClienteRepository = enderecoClienteRepository;
    }

    public List<endereco> getAllContasByClienteId(Long clienteId) {
        return enderecoClienteRepository.findAllByClienteId(clienteId);
    }

    public endereco getContaByIdAndClienteId(Long id, Long clienteId) {
        return enderecoClienteRepository.findByIdAndClienteId(id, clienteId);
    }

    public endereco createConta(endereco conta) {
        return enderecoClienteRepository.guardar(conta);
    }

    public endereco updateConta(endereco conta) {
        return enderecoClienteRepository.actualizar(conta);
    }

    public void deleteConta(Long id, Long clienteId) {
        enderecoClienteRepository.eliminar(id);
    }
}
