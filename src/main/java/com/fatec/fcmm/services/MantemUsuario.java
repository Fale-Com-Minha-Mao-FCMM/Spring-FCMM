package com.fatec.fcmm.services;

import com.fatec.fcmm.model.Usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface MantemUsuario {

    List<Usuario> consultaTodos();

    Optional<Usuario> consultaPorId(Long id);

    void delete(Long id);

    Optional<Usuario> consultaPorNome(String nome);
    
    Optional <Usuario> findByEmail (String email);

    Optional <Usuario> findBySenha (String senha);

    Optional<Usuario> save(Usuario usuario);

    Optional<Usuario> atualiza(Long id, Usuario usuario);

    Optional<Usuario> findByCapAtual (Integer capAtual);

    Optional <Usuario> findByIsAdmin (boolean isAdmin);

}
