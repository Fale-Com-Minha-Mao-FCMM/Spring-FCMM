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

    

    @GetMapping("/crudAluno")
    public ModelAndView showUser(){
     ModelAndView mv = new ModelAndView("crudAdminAluno");
         mv.addObject("usuarios", service.consultaTodos());

         return mv;
     }

    /*@GetMapping("/crudEstatisticas")
    public ModelAndView CrudEstatisticas() {
    return new ModelAndView("crudAdminEstatisticas");
    }*/

    //-----CRIAR USUARIO-----\\

    // Requisição GET 
    @GetMapping("/criar-usuario-admin")
    public ModelAndView getUsuariosAdmin(Usuario usuario) {
        ModelAndView mv = new ModelAndView("cadastrarUsuario");
        mv.addObject("usuario", usuario);

        return mv;
    }

    // Requisição POST 
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

    //----ATUALIZAR USUARIO-----\\

    // Requisição GET 
    @GetMapping("/atualizar-usuario-admin/{id}")
    public ModelAndView getUsuarioAdmin(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("atualizarUsuario");
        mv.addObject("usuario", service.consultaPorId(id).get());

        return mv;
    }

    // Requisição POST
    @PostMapping("/atualizar-usuario-admin/{id}")
    public RedirectView setUsuarioAdmin(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            usuario.setId(id);

            return new RedirectView("/atualizar-usuario-admin/{id}");
        }
        service.atualiza(id, usuario);

        return new RedirectView("/crudAluno");
    }

    //-----EXCLUIR USUARIO-----\\

    // Requisição GET 
    @GetMapping("/deletar-usuario-admin/{id}")
    public RedirectView deletarUsuario(@PathVariable("id") Long id) {
        service.delete(id);
        return new RedirectView("/crudAluno");
    }
}
