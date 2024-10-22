package com.example.practica_1.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.practica_1.models.negociacao;
import com.example.practica_1.repositories.NegociacaoRepository;

@Service
public class NegociacaoService {
    NegociacaoRepository negociacaoRepository;

    public NegociacaoService(NegociacaoRepository negociacaoRepository) {
        this.negociacaoRepository = negociacaoRepository;
    }

    public List<negociacao> getAllNegociacaos(){
        return negociacaoRepository.obtenerTodas();
    }

    public negociacao getNegociacaoById(Long id){
        return negociacaoRepository.obtenerPorId(id);
    }

    public negociacao createNegociacao(negociacao negociacao){
        return negociacaoRepository.guardar(negociacao);
    }

    public negociacao updateNegociacao(negociacao negociacao){
        return negociacaoRepository.actualizar(negociacao);
    }

    public void deleleteNegociacao(Long id){
        negociacaoRepository.eliminar(id);
    }
}
