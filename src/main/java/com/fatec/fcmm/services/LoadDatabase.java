package com.fatec.fcmm.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fatec.fcmm.model.Usuario.Usuario;
import com.fatec.fcmm.model.Usuario.MantemUsuarioRepository;

@Configuration
    class LoadDatabase {
        private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
        @Autowired
        MantemUsuarioRepository clienteRepository;

        @Bean
        CommandLineRunner initDatabase(MantemUsuarioRepository repository) {
            return args -> {
                // repository.deleteAll();
                // Usuario usuario1 = new Usuario("Jose da Silva", "01/03/1964", "M", "59672555598", "03694000", "2983");
                // usuario1.setEndereco("Aguia de Haia");
                // log.info("Preloading " + repository.save(usuario1));
                // Usuario usuario2 = new Usuario("Carlos Alberto", "19/08/1970", "M", "16467548671", "04280130", "59");
                // usuario2.setEndereco("Rua Frei Joao");
                // log.info("Preloading " + repository.save(usuario1));
            };
        }
    }
