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


@Controller
@RequestMapping
public class GUIUsuarioController {
    Logger logger = LogManager.getLogger(GUIUsuarioController.class);
    @Autowired
    MantemUsuario service;

    // @GetMapping("/usuario")
    // public ModelAndView showUser(){
    //     ModelAndView modelAndView = new ModelAndView("usuario/usuario");
    //     modelAndView.addObject("usuarios", service.consultaTodos());

    //     return modelAndView;
    // }

    // Requisição GET que irá mostrar a página de criação de Usuario
    @GetMapping("/criar-usuario")
    public ModelAndView cadastrarUsuario(Usuario usuario) {
        ModelAndView modelAndView = new ModelAndView("cadastroUsuario");
        modelAndView.addObject("usuario", usuario);

        return modelAndView;
    }

    //Requisição POST que irá criar um novo Usuario
    @PostMapping("/criar-usuario")
    public RedirectView createUsuario(@Valid Usuario usuario, BindingResult result){
        if (result.hasErrors()){
            return new RedirectView ("/criar-usuario");
            
        }

        if (!service.save(usuario).isPresent()){
            ModelAndView mv = new ModelAndView("cadastroUsuario");
            mv.addObject("message", "Dados inválidos");
        }

        return new RedirectView("/crudAluno");
    }
}
