package com.fatec.fcmm.model.Admin;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.fcmm.model.Usuario.Usuario;

@Repository
public interface MantemAdminRepository extends JpaRepository <Admin, Long> {
    Optional<Admin> findByNome(String nome);
    List<Admin> findAllByNomeIgnoreCaseContaining(String nome);       
}
