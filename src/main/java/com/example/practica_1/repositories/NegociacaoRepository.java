package com.example.practica_1.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;
import com.example.practica_1.models.negociacao;

@Repository
public class NegociacaoRepository {
    private List<negociacao> negociacaos = new ArrayList<negociacao>();
    private AtomicLong id = new AtomicLong();
    
    public negociacao guardar(negociacao negociacao) {
        negociacao.setId(id.incrementAndGet());
        negociacaos.add(negociacao);
        return negociacao;
    }

    public List<negociacao> obtenerTodas() {
        return negociacaos;
    }

    public negociacao obtenerPorId(Long id) {
        return negociacaos.stream().filter(negociacao -> negociacao.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        negociacaos.removeIf(negociacao -> negociacao.getId().equals(id));
    }

    public negociacao actualizar(negociacao negociacao) {
        eliminar(negociacao.getId());
        negociacaos.add(negociacao);
        return negociacao;  
    }
}
