package com.fatec.fcmm.model.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UsuarioDTO {
    @NotBlank(message = "Nome é requerido.")
    private String nome;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/-](0?[1-9]|1[012])[\\/-]\\d{4}$", message = "A data de nascimento deve estar no formato dd/MM/YYYY")
    private String dataNascimento;
    @NotBlank(message = "O email é obrigatório.")
    private String email;
    @NotBlank(message = "A senha é obrigatória.")
    private String senha;

    public UsuarioDTO(String nome, String dataNascimento, String email, String senha) {
        this.nome = nome;
        setDataNascimento(dataNascimento);
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public Usuario retornaUmUsuario() {
        return new Usuario(nome, dataNascimento, email, senha);
    }
}
