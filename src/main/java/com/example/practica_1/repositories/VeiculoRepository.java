package com.example.practica_1.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import com.example.practica_1.models.veiculo;

@Repository
public class VeiculoRepository {
    private List<veiculo> veiculos = new ArrayList<veiculo>();
    private AtomicLong id = new AtomicLong();
    
    public veiculo guardar(veiculo veiculo) {
        veiculo.setId(id.incrementAndGet());
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<veiculo> obtenerTodas() {
        return veiculos;
    }

    public veiculo obtenerPorId(Long id) {
        return veiculos.stream().filter(veiculo -> veiculo.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminar(Long id) {
        veiculos.removeIf(veiculo -> veiculo.getId().equals(id));
    }

    public veiculo actualizar(veiculo veiculo) {
        eliminar(veiculo.getId());
        veiculos.add(veiculo);
        return veiculo;  
    }
    
}
