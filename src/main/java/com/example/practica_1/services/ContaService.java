package com.example.practica_1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practica_1.models.Conta;
import com.example.practica_1.repositories.ContaRepository;

@Service
public class ContaService {

    ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> getAllContas(){
        return contaRepository.obtenerTodas();
    }

    public Conta getContaById(Long id){
        return contaRepository.obtenerPorId(id);
    }

    public Conta createConta(Conta conta){
        return contaRepository.guardar(conta);
    }

    public Conta updateConta(Conta conta){
        return contaRepository.actualizar(conta);
    }

    public void deleleteConta(Long id){
        contaRepository.eliminar(id);
    }
    
}
