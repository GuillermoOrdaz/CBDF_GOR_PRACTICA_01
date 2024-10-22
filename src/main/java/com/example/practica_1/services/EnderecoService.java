package com.example.practica_1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practica_1.models.endereco;
import com.example.practica_1.repositories.enderecoRepository;

@Service
public class EnderecoService {
    enderecoRepository enderecoRepository;

    public EnderecoService(com.example.practica_1.repositories.enderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<endereco> getAllEnderecos(){
        return enderecoRepository.obtenerTodas();
    }

    public endereco getEnderecoById(Long id){
        return enderecoRepository.obtenerPorId(id);
    }

    public endereco createEndereco(endereco endereco){
        return enderecoRepository.guardar(endereco);
    }

    public endereco updateEndereco(endereco endereco){
        return enderecoRepository.actualizar(endereco);
    }

    public void deleleteEndereco(Long id){
        enderecoRepository.eliminar(id);
    }
    
}
