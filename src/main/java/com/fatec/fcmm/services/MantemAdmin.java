package com.fatec.fcmm.services;

import com.fatec.fcmm.model.Admin.Admin;

import java.util.List;
import java.util.Optional;

public interface MantemAdmin {

    List<Admin> consultaTodos();

    Optional<Admin> consultaPorId (Long id);

    void delete (Long id);

    Optional <Admin> consultaPorNome(String Nome);

    Optional <Admin> save (Admin admin);

    Optional <Admin> atualiza(Long id, Admin admin);
   
}
