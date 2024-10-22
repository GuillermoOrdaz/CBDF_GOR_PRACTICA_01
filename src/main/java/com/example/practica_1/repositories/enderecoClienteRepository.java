package com.example.practica_1.repositories;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.example.practica_1.models.endereco;
import java.util.stream.Collectors;

@Repository
public class enderecoClienteRepository {
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

    public List<endereco> findAllByClienteId(Long clienteId) {
        return enderecos.stream().filter(endereco -> endereco.getId_cliente().equals(clienteId)).collect(Collectors.toList());
        
    }

    public endereco obtenerPorId(Long id) {
        return enderecos.stream().filter(endereco -> endereco.getId_cliente().equals(id)).findFirst().orElse(null);
    }

    public endereco findByIdAndClienteId(Long id, Long clienteId) {
        return enderecos.stream()
            .filter(endereco -> endereco.getIdendereco().equals(id) && endereco.getId_cliente().equals(clienteId))
            .findFirst().orElse(null);
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
