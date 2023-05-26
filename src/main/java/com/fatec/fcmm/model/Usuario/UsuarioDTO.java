package com.fatec.fcmm.model.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UsuarioDTO {
    @NotBlank (message = "Email é requirido")
    private String email;

    @NotBlank (message = "Confirmação do email é requirido")
    private String confirmarEmail;

    @NotBlank (message = "A senha é requirida")
    private String senha;

    @NotBlank (message = "Confirmação de senha é requirida")
    private String confirmarSenha;

    @NotBlank (message = "Nome é requirido")
    private String nome;

    @NotBlank (message = "Sobrenome é requirido")
    private String sobrenome;

    @NotBlank (message = "Telefone é requirido")
    private String telefone;

    @NotBlank (message = "Capitulo é requirido")
	private Integer capAtual = 1;

    @NotBlank (message = "IsAdmin é requirido")
	private boolean isAdmin;

    //Construtores
    public UsuarioDTO() {}


    public UsuarioDTO(@NotBlank(message = "Email é requirido") String email,
            @NotBlank(message = "Confirmação do email é requirido") String confirmarEmail,
            @NotBlank(message = "A senha é requirida") String senha,
            @NotBlank(message = "Confirmação de senha é requirida") String confirmarSenha,
            @NotBlank(message = "Nome é requirido") String nome,
            @NotBlank(message = "Sobrenome é requirido") String sobrenome,
            @NotBlank(message = "Telefone é requirido") String telefone,
            @NotBlank(message = "Capitulo é requirido") Integer capAtual,
            @NotBlank(message = "IsAdmin é requirido") boolean isAdmin) {
        this.email = email;
        this.confirmarEmail = confirmarEmail;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.capAtual = capAtual;
        this.isAdmin = isAdmin;
    }

    //Getters e Setters

    public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCapAtual() {
		return capAtual;
	}

	public void setCapAtual(Integer capAtual) {
		this.capAtual = capAtual;
	}

    public Usuario retornaUmUsuario(){
        return new Usuario(email, confirmarEmail, senha, confirmarSenha, nome, sobrenome, telefone, capAtual, isAdmin);
    }

   

    
}
