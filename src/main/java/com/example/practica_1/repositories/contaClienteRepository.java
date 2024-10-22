package com.example.practica_1.repositories;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.example.practica_1.models.Conta;
import java.util.stream.Collectors;

@Repository
public class contaClienteRepository {
    private List<Conta> contas = new ArrayList<Conta>();
    private AtomicLong id = new AtomicLong();

    public Conta guardar(Conta conta) {
        conta.setId(id.incrementAndGet());
        contas.add(conta);
        return conta;
    }

    public List<Conta> obtenerTodas() {
        return contas;
    }

    public List<Conta> findAllByClienteId(Long clienteId) {
        return contas.stream().filter(conta -> conta.getId_cliente().equals(clienteId)).collect(Collectors.toList());
        
    }

    public Conta obtenerPorId(Long id) {
        return contas.stream().filter(conta -> conta.getId().equals(id)).findFirst().orElse(null);
    }

    public Conta findByIdAndClienteId(Long id, Long clienteId) {
        return contas.stream()
            .filter(conta -> conta.getId().equals(id) && conta.getId_cliente().equals(clienteId))
            .findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        contas.removeIf(conta -> conta.getId().equals(id));
    }

    public Conta actualizar(Conta conta) {
        eliminar(conta.getId());
        contas.add(conta);
        return conta;  
    }
    
}
