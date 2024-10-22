package com.example.practica_1.services;

import com.example.practica_1.models.Conta;
import com.example.practica_1.repositories.contaClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class contaClienteService {
    private contaClienteRepository contaClienteRepository;


    public contaClienteService(contaClienteRepository contaClienteRepository) {
        this.contaClienteRepository = contaClienteRepository;
    }

    public List<Conta> getAllContasByClienteId(Long clienteId) {
        return contaClienteRepository.findAllByClienteId(clienteId);
    }

    public Conta getContaByIdAndClienteId(Long id, Long clienteId) {
        return contaClienteRepository.findByIdAndClienteId(id, clienteId);
    }

    public Conta createConta(Conta conta) {
        return contaClienteRepository.guardar(conta);
    }

    public Conta updateConta(Conta conta) {
        return contaClienteRepository.actualizar(conta);
    }

    public void deleteConta(Long id, Long clienteId) {
        contaClienteRepository.eliminar(id);
    }
}
