package com.example.practica_1.models;

public class Conta {
    private Long id;
    private int agencia;
    private String banco;
    private Long id_cliente;

    public Conta() {}

    public Conta(Long id, int agencia, String banco, Long id_cliente) {
        this.id = id;
        this.agencia = agencia;
        this.banco = banco;
        this.id_cliente = id_cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    

}
