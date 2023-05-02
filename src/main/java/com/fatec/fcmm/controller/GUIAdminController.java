package com.fatec.fcmm.controller;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.fcmm.model.Usuario.Usuario;
import com.fatec.fcmm.services.MantemUsuario;

import ch.qos.logback.core.model.Model;

import org.springframework.web.servlet.view.RedirectView;

public class GUIAdminController {
    Logger looger = LogManager.getLogger(GUIAdminController.class);
    @Autowired
    MantemUsuario service;

    //Requisição GET que vai mostrar a págida de criação de aluno.
    @GetMapping("/criar-usuario-admin")
    public ModelAndView verUsuariosAdmin(Usuario usuario){
        ModelAndView mv = new ModelAndView("");
        mv.addObject("usuario", usuario);

        return mv;
    }

    //Requisição POST que irá criar o usuário!
    @PostMapping("/criar-usuario-admin")
    public RedirectView criarUsuarioAdmin(@Valid Usuario usuario, BindingResult result){
        if (result.hasErrors()){
            return new RedirectView("/criar-usuario-admin");
        }

        if(!service.save(usuario).isPresent()){
            ModelAndView mv = new ModelAndView("");
            mv.addObject("message", "Dados inválidos");
        }

        return new RedirectView("/crudAlunos");
    }
}
