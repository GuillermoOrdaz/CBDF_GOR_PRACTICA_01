package com.example.practica_1.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import com.example.practica_1.models.cliente;

@Repository
public class ClienteRepository {
    private List<cliente> clientes = new ArrayList<cliente>();
    private AtomicLong id = new AtomicLong();
    
    public cliente guardar(cliente cliente) {
        cliente.setId(id.incrementAndGet());
        clientes.add(cliente);
        return cliente;
    }

    public List<cliente> obtenerTodas() {
        return clientes;
    }

    public cliente obtenerPorId(Long id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    public cliente actualizar(cliente cliente) {
        eliminar(cliente.getId());
        clientes.add(cliente);
        return cliente;  
    }

}
