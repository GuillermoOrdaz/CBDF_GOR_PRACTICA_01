package com.example.practica_1.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.practica_1.models.cliente;
import com.example.practica_1.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<cliente> getAllClientes(){
        return clienteRepository.obtenerTodas();
    }

    public cliente getClienteById(Long id){
        return clienteRepository.obtenerPorId(id);
    }

    public cliente createCliente(cliente cliente){
        return clienteRepository.guardar(cliente);
    }

    public cliente updateCliente(cliente cliente){
        return clienteRepository.actualizar(cliente);
    }

    public void deleleteCliente(Long id){
        clienteRepository.eliminar(id);
    }

}
