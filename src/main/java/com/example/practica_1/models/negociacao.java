package com.example.practica_1.models;

public class negociacao {
    private Long id;
    private float valor_fipe;
    private float valor_venda;
    private float valor_compra;
    private String descricao;
    private Long id_veiculo;
    private Long id_cliente;

    public negociacao() {}

    public negociacao(Long id, float valor_fipe, float valor_venda, float valor_compra, String descricao,
            Long id_veiculo, Long id_cliente) {
        this.id = id;
        this.valor_fipe = valor_fipe;
        this.valor_venda = valor_venda;
        this.valor_compra = valor_compra;
        this.descricao = descricao;
        this.id_veiculo = id_veiculo;
        this.id_cliente = id_cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(float valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public float getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(float valor_compra) {
        this.valor_compra = valor_compra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    
    
}
