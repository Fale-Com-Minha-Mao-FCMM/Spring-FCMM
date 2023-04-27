package com.fatec.fcmm.model;

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
}
