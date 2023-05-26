package com.fatec.fcmm.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fcmm.model.Admin.MantemAdminRepository;
import com.fatec.fcmm.model.Admin.Admin; 

@Service
public class MantemAdminI  implements MantemAdmin{
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    MantemAdminRepository repository;

    @Override
    public List<Admin> consultaTodos(){
        logger.info(">>>>> serviço consultaTodos chamado");
        return repository.findAll();
    }

    @Override
    public Optional<Admin> consultaPorId(Long id) {
        logger.info (">>>>> serviço consultaPorId chamado");
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logger.info(">>>>>> servico delete por id chamado");
        repository.deleteById(id);
    }

    @Override
    public Optional<Admin> consultaPorNome(String Nome) {
        logger.info(">>>>>> servico consultaPorNome chamado");
        return repository.findByNome(Nome);
    }


    @Override
    public Optional<Admin> save(Admin admin) {
        logger.info(">>>>>> servico save chamado ");
        return Optional.ofNullable(repository.save(admin));
    }

    @Override
    public Optional<Admin> atualiza (Long id, Admin admin) {
        logger.info(">>>>>> 1.servico atualiza informações do usuario chamado");
        Admin adminModificado = new Admin(admin.getEmail(),  admin.getSenha(), admin.getNome(), admin.getSobrenome(), false);
        adminModificado.setId(id);
        logger.info(adminModificado.getId());
        return Optional.ofNullable(repository.save(adminModificado));
    }
    
}
