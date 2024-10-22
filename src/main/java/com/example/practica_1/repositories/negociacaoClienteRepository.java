package com.example.practica_1.repositories;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.example.practica_1.models.negociacao;
import java.util.stream.Collectors;

@Repository
public class negociacaoClienteRepository {
    private List<negociacao> enderecos = new ArrayList<negociacao>();
    private AtomicLong id = new AtomicLong();

    public negociacao guardar(negociacao endereco) {
        endereco.setId(id.incrementAndGet());
        enderecos.add(endereco);
        return endereco;
    }

    public List<negociacao> obtenerTodas() {
        return enderecos;
    }

    public List<negociacao> findAllByClienteId(Long clienteId) {
        return enderecos.stream().filter(endereco -> endereco.getId_cliente().equals(clienteId)).collect(Collectors.toList());
        
    }

    public negociacao obtenerPorId(Long id) {
        return enderecos.stream().filter(endereco -> endereco.getId_cliente().equals(id)).findFirst().orElse(null);
    }

    public negociacao findByIdAndClienteId(Long id, Long clienteId) {
        return enderecos.stream()
            .filter(endereco -> endereco.getId().equals(id) && endereco.getId_cliente().equals(clienteId))
            .findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        enderecos.removeIf(endereco -> endereco.getId().equals(id));
    }

    public negociacao actualizar(negociacao endereco) {
        eliminar(endereco.getId());
        enderecos.add(endereco);
        return endereco;  
    }
}
