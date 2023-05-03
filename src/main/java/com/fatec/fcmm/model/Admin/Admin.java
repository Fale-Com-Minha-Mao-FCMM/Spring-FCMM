package com.fatec.fcmm.model.Admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank (message = "Email é requirido")
    private String email;

    @NotBlank (message = "Senha é requirida")
    private String senha;
    
    @NotBlank (message = "Nome é requirido")
    private String nome;

    @NotBlank (message = "Sobrenome é requirido")
    private String sobrenome;


    //Método construtores
    public Admin() {}

    public Admin(@NotBlank(message = "Email é requirido") String email,
            @NotBlank(message = "Senha é requirida") String senha, @NotBlank(message = "Nome é requirido") String nome,
            @NotBlank(message = "Sobrenome é requirido") String sobrenome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }


    //Getter e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
