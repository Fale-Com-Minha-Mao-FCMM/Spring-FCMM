package com.fatec.fcmm.model.Usuario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome é requerido")
	private String nome;
	@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/-](0?[1-9]|1[012])[\\/-]\\d{4}$", message = "A data de nascimento deve estar no formato dd/MM/YYYY")
	//https://www.regular-expressions.info/
	private String dataNascimento;
	private String dataCadastro;
	@NotBlank(message = "Sexo M/F")
	private String sexo;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
        if (validaData(dataNascimento) == true) {
            this.dataNascimento = dataNascimento;
        } else {
            throw new IllegalArgumentException("Data invalida");
        }
    }
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public boolean validaData(String data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false); //
        try {
            df.parse(data); // data válida (exemplo 30 fev - 31 nov)
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

	public Usuario(@NotBlank(message = "Nome é requerido") String nome,
			@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/-](0?[1-9]|1[012])[\\/-]\\d{4}$", message = "A data de nascimento deve estar no formato dd/MM/YYYY") String dataNascimento,
			String dataCadastro, @NotBlank(message = "Sexo M/F") String sexo, @NotBlank String email,
			@NotBlank String senha) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
	}
	public Usuario(@NotBlank(message = "Nome é requerido.") String nome2,
			@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/-](0?[1-9]|1[012])[\\/-]\\d{4}$", message = "A data de nascimento deve estar no formato dd/MM/YYYY") String dataNascimento2,
			@NotBlank(message = "O email é obrigatório.") String email2,
			@NotBlank(message = "A senha é obrigatória.") String senha2) {
	}
}
