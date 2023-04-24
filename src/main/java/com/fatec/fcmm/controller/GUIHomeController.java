package com.fatec.fcmm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//Essa classe será responsável por controlar e retornar as views.

@Controller
public class GUIHomeController {
/**
* processa a requisicao localhost:8080/
* @return a view html
*/

@GetMapping("/")
public ModelAndView menu() {
return new ModelAndView("homeUsuario");
}
/**
* processa a requisicao localhost:8080/clientes
* @return a view html
*/
@GetMapping("/cadastro")
public ModelAndView formCliente() {
return new ModelAndView("cadastroUsuario");
}
@GetMapping("/admin")
public ModelAndView formAdmin() {
    return new ModelAndView("crudAdmin");
}

}