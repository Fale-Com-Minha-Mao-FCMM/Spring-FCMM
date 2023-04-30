package com.fatec.fcmm.services;

import com.fatec.fcmm.model.Usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface MantemUsuario {

    List<Usuario> consultaTodos();

    Optional<Usuario> consultaPorId(Long id);

    void delete(Long id);

    Optional<Usuario> consultaPorNome(String Nome);

    Optional<Usuario> save(Usuario usuario);

    Optional<Usuario> atualiza(Long id, Usuario usuario);
}

