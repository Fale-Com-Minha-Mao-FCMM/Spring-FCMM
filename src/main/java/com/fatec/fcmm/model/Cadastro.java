package com.fatec.fcmm.model;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank (message = "Nome é requirido")
    private String nome;

    @NotBlank (message = "Sobrenome é requirido")
    private String sobrenome;

    @NotBlank (message = "Email é requirido")
    private String email;

    @NotBlank (message = "Confirmação do email é requirido")
    private String confirmarEmail;

    @NotBlank (message = "A senha é requirida")
    private String senha;

    @NotBlank (message = "Confirmação de senha é requirida")
    private String confirmarSenha;

    @NotBlank (message = "Telefone é requirido")
    private String telefone;

    
    // Construtores
    public Cadastro() {}

    public Cadastro(@NotBlank(message = "Nome é requirido") String nome,
            @NotBlank(message = "Sobrenome é requirido") String sobrenome,
            @NotBlank(message = "Email é requirido") String email,
            @NotBlank(message = "Confirmação do email é requirido") String confirmarEmail,
            @NotBlank(message = "A senha é requirida") String senha,
            @NotBlank(message = "Confirmação de senha é requirida") String confirmarSenha,
            @NotBlank(message = "Telefone é requirido") String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.confirmarEmail = confirmarEmail;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
        this.telefone = telefone;
    }


    

    //Getters e Setters
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getConfirmarEmail() {
        return confirmarEmail;
    }
    
    public void setConfirmarEmail(String confirmarEmail) {
        this.confirmarEmail = confirmarEmail;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getConfirmarSenha() {
        return confirmarSenha;
    }
    
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    

    
}
