package com.fatec.fcmm.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fcmm.model.Cadastro;
import com.fatec.fcmm.model.MantemCadastroRepository;

@Service
public class MantemCadastroI implements MantemCadastro {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MantemCadastroRepository repository;

	@Override
	public List<Cadastro> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}
	
	@Override
	public @Valid Cadastro searchByEmail(String email) {
		logger.info(">>>>>> servico consultaPorEmail chamado");
		return repository.findByEmail(email);
	}
	
	@Override
	public Optional<Cadastro> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}
	
	@Override
	public Optional<Cadastro> save(Cadastro cadastro) { 
	 logger.info(">>>>>> servico save chamado ");
	 return Optional.ofNullable(repository.save(cadastro)); 
	}
	
	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}
	
	@Override
	public Optional<Cadastro> updates(Long id, Cadastro cadastro) {
		logger.info(">>>>>> servico atualiza informações de cadastro chamado");
		Cadastro cadastroModificado = new Cadastro(cadastro.getNome(), cadastro.getSobrenome(), cadastro.getEmail(), cadastro.getConfirmarEmail() ,cadastro.getSenha(), cadastro.getConfirmarSenha(), cadastro.getTelefone());
		cadastroModificado.setId(id);
		return Optional.ofNullable(repository.save(cadastroModificado));
	}

	@Override
	public Optional<Cadastro> updates(String email, String senha) {
		logger.info(">>>>>> servico atualiza senha de cadastro chamado");
		Cadastro cadastroAuxiliar = repository.findByEmail(email);
		Cadastro cadastroModificado = new Cadastro(cadastroAuxiliar.getNome(), cadastroAuxiliar.getSobrenome(), cadastroAuxiliar.getEmail(), cadastroAuxiliar.getConfirmarEmail() ,cadastroAuxiliar.getSenha(), cadastroAuxiliar.getConfirmarSenha(), cadastroAuxiliar.getTelefone());
		cadastroModificado.setId(cadastroAuxiliar.getId());
		cadastroModificado.setSenha(senha);
		cadastroModificado.setConfirmarSenha(senha);
		return Optional.ofNullable(repository.save(cadastroModificado));
	}

	@Override
	public Boolean existsByEmail(String email) {
		logger.info(">>>>>> servico verifica se existe cadastro chamado");
		if (repository.existsByEmail(email)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean verify(String email, String senha) {
		logger.info(">>>>>> servico verifica se cadastro chamado e valido");
		Cadastro cadastroAuxiliar = repository.findByEmail(email);
		if (email.equals(cadastroAuxiliar.getEmail()) && senha.equals(cadastroAuxiliar.getSenha())) {
			return true;
		}
		return false;
	}
}
