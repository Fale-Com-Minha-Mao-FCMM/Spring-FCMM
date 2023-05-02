package com.fatec.fcmm.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fatec.fcmm.model.Cadastro;

public interface MantemCadastro {
	List<Cadastro> searchAll();

	@Valid Cadastro searchByEmail(String email);

	@Valid Optional<Cadastro> searchById(Long id);

	Optional<Cadastro> save(Cadastro cadastro);

	void delete(Long id);

	Optional<Cadastro> updates(Long id, Cadastro cadastro);

	Optional<Cadastro> updates(String email, String senha);
	
	Boolean existsByEmail(String email);
	
	Boolean verify(String email, String senha);
}