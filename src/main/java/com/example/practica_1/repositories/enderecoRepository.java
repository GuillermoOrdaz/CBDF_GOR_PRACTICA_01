package com.example.practica_1.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.practica_1.models.endereco;

@Repository
public class enderecoRepository {
    private List<endereco> enderecos = new ArrayList<endereco>();
    private AtomicLong id = new AtomicLong();
    
    public endereco guardar(endereco endereco) {
        endereco.setIdendereco(id.incrementAndGet());
        enderecos.add(endereco);
        return endereco;
    }

    public List<endereco> obtenerTodas() {
        return enderecos;
    }

    public endereco obtenerPorId(Long id) {
        return enderecos.stream().filter(endereco -> endereco.getIdendereco().equals(id)).findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        enderecos.removeIf(endereco -> endereco.getIdendereco().equals(id));
    }

    public endereco actualizar(endereco endereco) {
        eliminar(endereco.getIdendereco());
        enderecos.add(endereco);
        return endereco;  
    }
    
}
