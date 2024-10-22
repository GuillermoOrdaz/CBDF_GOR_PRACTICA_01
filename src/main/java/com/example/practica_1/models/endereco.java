package com.example.practica_1.models;

public class endereco {
    private Long id;
    private String cep;
    private String rua;
    private String cidade;
    private String uf;
    private Long id_cliente;

    public endereco() {}

    public endereco(Long id, String cep, String rua, String cidade, String uf, Long id_cliente) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.uf = uf;
        this.id_cliente = id_cliente;
    }

    public Long getIdendereco() {
        return id;
    }

    public void setIdendereco(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    
    
}
