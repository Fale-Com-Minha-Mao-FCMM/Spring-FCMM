package com.fatec.fcmm.services;

import com.fatec.fcmm.model.Usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface MantemUsuario {

    public List<Usuario> consultaTodos();

    public Optional<Usuario> consultaPorId(Long id);

    public void delete(Long id);

    public Optional<Usuario> consultaPorNome(String Nome);

    public Optional<Usuario> save(Usuario usuario);

    public Optional<Usuario> atualiza(Long id, Usuario usuario);
}

