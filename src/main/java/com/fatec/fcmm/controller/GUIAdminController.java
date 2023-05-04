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
public class GUIAdminController {
    Logger looger = LogManager.getLogger(GUIAdminController.class);
    @Autowired
    MantemUsuario service;

    // @GetMapping("/")
    // public ModelAndView menu() {
    //     return new ModelAndView("homeUsuario");
    // }

    @GetMapping("/crud")
    public ModelAndView formCrud() {
        return new ModelAndView("crudAdminHome");
    }

    @GetMapping("/crudAdministradores")
    public ModelAndView showAdmin(){
        ModelAndView mv = new ModelAndView("crudAdmin");
        // mv.addObject("");
        return mv;
    }



    @GetMapping("/crudAluno")
    public ModelAndView showUser(){
     ModelAndView modelAndView = new ModelAndView("crudAdminAluno");
         modelAndView.addObject("usuarios", service.consultaTodos());

         return modelAndView;
     }
    // @GetMapping("/crudAluno")
    // public ModelAndView formCrudAluno() {
    //     return new ModelAndView("crudAdminAluno");
    // }

    @GetMapping("/crudCapitulos")
    public ModelAndView formCrudCapitulos() {
        return new ModelAndView("crudAdminCapitulos");
    }

    // Requisição GET que vai mostrar a págida de criação de aluno.
    @GetMapping("/criar-usuario-admin")
    public ModelAndView getUsuariosAdmin(Usuario usuario) {
        ModelAndView mv = new ModelAndView("cadastrarUsuario");
        mv.addObject("usuario", usuario);

        return mv;
    }

    // Requisição POST que irá criar o usuário!
    @PostMapping("/criar-usuario-admin")
    public RedirectView createUsuario(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return new RedirectView("/crudAluno");
        }

        if (!service.save(usuario).isPresent()) {
            ModelAndView mv = new ModelAndView("cadastrarUsuario");
            mv.addObject("message", "Dados inválidos");
        }

        return new RedirectView("/crudAluno");
    }

    // Requisição GET que irá mostrar a página de atualização de cliente
    @GetMapping("/atualizar-usuario-admin/{id}")
    public ModelAndView getUsuarioAdmin(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("atualizarUsuario");
        mv.addObject("usuario", service.consultaPorId(id).get());

        return mv;
    }

    // Requisição POST que irá atualizar um cliente
    @PostMapping("/atualizar-usuario-admin/{id}")
    public RedirectView setUsuarioAdmin(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            usuario.setId(id);

            return new RedirectView("/atualizar-usuario-admin/{id}");
        }
        service.atualiza(id, usuario);

        return new RedirectView("/crudAluno");
    }

    // Requisição GET que irá mostrar a página de excluir cliente
    @GetMapping("/deletar-usuario-admin/{id}")
    public RedirectView deletarUsuario(@PathVariable("id") Long id) {
        service.delete(id);
        return new RedirectView("/crudAluno");
    }
}
