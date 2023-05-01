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
                repository.deleteAll();
                Usuario usuario1 = new Usuario();
                log.info("Preloading " + repository.save(usuario1));
                Usuario usuario2 = new Usuario();
                log.info("Preloading " + repository.save(usuario1));
            };
        }
    }
