package com.example.practica_1.repositories;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.example.practica_1.models.veiculo;
import java.util.stream.Collectors;

@Repository
public class veiculoClienteRepository {
    private List<veiculo> enderecos = new ArrayList<veiculo>();
    private AtomicLong id = new AtomicLong();

    public veiculo guardar(veiculo endereco) {
        endereco.setId(id.incrementAndGet());
        enderecos.add(endereco);
        return endereco;
    }

    public List<veiculo> obtenerTodas() {
        return enderecos;
    }

    public List<veiculo> findAllByClienteId(Long clienteId) {
        return enderecos.stream().filter(endereco -> endereco.getId_cliente().equals(clienteId)).collect(Collectors.toList());
        
    }

    public veiculo obtenerPorId(Long id) {
        return enderecos.stream().filter(endereco -> endereco.getId_cliente().equals(id)).findFirst().orElse(null);
    }

    public veiculo findByIdAndClienteId(Long id, Long clienteId) {
        return enderecos.stream()
            .filter(endereco -> endereco.getId().equals(id) && endereco.getId_cliente().equals(clienteId))
            .findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        enderecos.removeIf(endereco -> endereco.getId().equals(id));
    }

    public veiculo actualizar(veiculo endereco) {
        eliminar(endereco.getId());
        enderecos.add(endereco);
        return endereco;  
    }
}
