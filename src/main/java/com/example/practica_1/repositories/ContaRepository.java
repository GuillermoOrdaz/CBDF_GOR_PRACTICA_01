package com.example.practica_1.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import com.example.practica_1.models.Conta;


@Repository
public class ContaRepository {
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

    public Conta obtenerPorId(Long id) {
        return contas.stream().filter(conta -> conta.getId().equals(id)).findFirst().orElse(null);
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
