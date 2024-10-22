package com.example.practica_1.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.practica_1.models.veiculo;
import com.example.practica_1.repositories.VeiculoRepository;

@Service
public class VeiculoService {
    VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<veiculo> getAllVeiculos(){
        return veiculoRepository.obtenerTodas();
    }

    public veiculo getVeiculoById(Long id){
        return veiculoRepository.obtenerPorId(id);
    }

    public veiculo createVeiculo(veiculo veiculo){
        return veiculoRepository.guardar(veiculo);
    }

    public veiculo updateVeiculo(veiculo veiculo){
        return veiculoRepository.actualizar(veiculo);
    }

    public void deleleteVeiculo(Long id){
        veiculoRepository.eliminar(id);
    }
}
