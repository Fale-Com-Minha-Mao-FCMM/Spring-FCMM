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

import com.fatec.fcmm.model.Admin.Admin;
import com.fatec.fcmm.services.MantemAdmin;

import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
public class GUIcrudAdminController {
    Logger looger = LogManager.getLogger(GUIcrudAdminController.class);
    @Autowired
    MantemAdmin service;

    @GetMapping("/crudAdministradores")
    public ModelAndView showAdmin(){
        ModelAndView mv = new ModelAndView("crudAdmin");
        mv.addObject("admin",service.consultaTodos());
        return mv;
    }

     //-----------CRUD ADMIN--------------\\


    //-----CRIAR ADMIN-----\\

    // Requisição GET
    @GetMapping("/criar-admin")
    public ModelAndView getAdmin(Admin admin) {
        ModelAndView mv = new ModelAndView("cadastrarAdmin");
        mv.addObject("admin", admin);

        return mv;
    }

    // Requisição POST
    @PostMapping("/criar-admin")
    public RedirectView createAdmin(@Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return new RedirectView("/crudAdministradores");
        }

        if (!service.save(admin).isPresent()) {
            ModelAndView mv = new ModelAndView("cadastrarAdmin");
            mv.addObject("message", "Dados inválidos");
        }

        return new RedirectView("/crudAdministradores");
    }


    //------ATUALIZAR ADMIN------\\

    //Requisição GET
    @GetMapping("/atualizar-admin/{id}")
    public ModelAndView getAdmin(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("atualizarAdmin");
        mv.addObject("admin",service.consultaPorId(id).get());
    
    return mv;
    }

    //Requisição POST
    @PostMapping("/atualizar-admin/{id}")
    public RedirectView setAdmin(@PathVariable("id") long id, @Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            admin.setId(id);

            return new RedirectView("/atualizar-admin/{id}");
        }
        service.atualiza(id, admin);

        return new RedirectView("/crudAdministradores");
    }

    //-----DELETAR ADMIN-----\\

    // Requisição GET
    @GetMapping("/deletar-admin/{id}")
    public RedirectView deletarAdmin(@PathVariable("id") Long id) {
        service.delete(id);
        return new RedirectView("/crudAdministradores");
    }

}
