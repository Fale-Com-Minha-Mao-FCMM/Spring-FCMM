package com.fatec.fcmm.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fcmm.model.Usuario.MantemUsuarioRepository;
import com.fatec.fcmm.model.Usuario.Usuario; 

@Service
public class MantemUsuarioI implements MantemUsuario {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    MantemUsuarioRepository repository;

    @Override
    public List<Usuario> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> consultaPorId(Long id) {
        logger.info(">>>>>> servico consultaPorId chamado");
        return repository.findById(id);
    }


    @Override
    public void delete(Long id) {
        logger.info(">>>>>> servico delete por id chamado");
        repository.deleteById(id);
    }

    @Override
    public Optional<Usuario> consultaPorNome(String Nome) {
        logger.info(">>>>>> servico consultaPorNome chamado");
        return repository.findByNome(Nome);
    }


    @Override
    public Optional<Usuario> save(Usuario usuario) {
        logger.info(">>>>>> servico save chamado ");
        return Optional.ofNullable(repository.save(usuario));
    }

    @Override
    public Optional<Usuario> atualiza (Long id, Usuario usuario) {
        logger.info(">>>>>> 1.servico atualiza informações do usuario chamado");
        Usuario usuarioModificado = new Usuario(usuario.getEmail(), usuario.getConfirmarEmail(), usuario.getSenha(), usuario.getConfirmarSenha(), usuario.getNome(), usuario.getSobrenome(), usuario.getTelefone(), usuario.getCapAtual());
        usuarioModificado.setId(id);
        logger.info(usuarioModificado.getId());
        return Optional.ofNullable(repository.save(usuarioModificado));
    }

}
