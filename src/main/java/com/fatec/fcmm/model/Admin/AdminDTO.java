package com.fatec.fcmm.model.Admin;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AdminDTO {
    @NotBlank (message = "Email é requirido")
    private String email;

    @NotBlank (message = "A senha é requirida")
    private String senha;

    @NotBlank (message = "Nome é requirido")
    private String nome;

    @NotBlank (message = "Sobrenome é requirido")
    private String sobrenome;

    //Construtores
    public AdminDTO() {}
    
    public AdminDTO(@NotBlank(message = "Email é requirido") String email,
    @NotBlank(message = "A senha é requirida") String senha,
    @NotBlank(message = "Nome é requirido") String nome,
    @NotBlank(message = "Sobrenome é requirido") String sobrenome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    //Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Admin retornaUmAdmin(){
        return new Admin(email, senha, nome, sobrenome);
    }

}
