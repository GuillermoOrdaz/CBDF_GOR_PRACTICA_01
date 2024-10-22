package com.example.practica_1.models;

public class cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String cnh;
    private String email;
    private String telefone;
    private Long id_endereco;

    public cliente() {}

    public cliente(Long id, String nome, String cpf, String cnh, String email, String telefone, Long id_endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.email = email;
        this.telefone = telefone;
        this.id_endereco = id_endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    

}
