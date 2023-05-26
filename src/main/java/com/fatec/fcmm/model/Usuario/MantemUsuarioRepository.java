package com.fatec.fcmm.model.Usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.fcmm.model.Usuario.Usuario;

/**
 * Esta classe abstrai a programação de consultas para acesso ao banco de dados.
 * O nome dos metodos para consulta têm duas partes separadas pela palavra-chave
 * By. A primeira parte é o “find” seguido de By. A segunda parte é o nome do
 * atribudo na tabela por exemplo Cpf - findByCpf
 * 
 * @author
 */
@Repository
public interface MantemUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNome(String nome);

    List<Usuario> findAllByNomeIgnoreCaseContaining(String nome);

    Optional<Usuario> findByEmail (String email);

    Optional<Usuario> findBySenha (String senha);

    Optional <Usuario> findByCapAtual (Integer capAtual);

    Optional<Usuario> findByIsAdmin(boolean isAdmin);


}