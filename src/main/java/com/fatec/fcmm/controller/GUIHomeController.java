package com.fatec.fcmm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.fcmm.model.Cadastro;
import com.fatec.fcmm.services.MantemCadastro;
import org.springframework.web.bind.annotation.RequestParam;


//Essa classe será responsável por controlar e retornar as views.

/*Como criar rota?
 * Para criar a rota é bem simples, pasta tu começar com o @GetMapping e entre parenteses e aspas você vai colocar o nome da rota.
 * no caso do @GetMapping("/") ele declara que é home (inicio do site).
 * Depois disso, voce escreve public ModelAndView qualquerCoisa() e abre as chaves {}.
 * Dentro das chaves você vai colocar 'return new ModelAndView("nomeIdenticoAoDoHTML");'
 * OBS: Não precisa colocar ".html" no final, apenas o nome.
*/

@Controller
@RequestMapping
public class GUIHomeController {

@Autowired
MantemCadastro service;

@GetMapping("/")
public ModelAndView menu() {
return new ModelAndView("index");
}

@GetMapping("/login")
public ModelAndView formLogin() {
    return new ModelAndView("login");
}

//@GetMapping("/crud")
//public ModelAndView formCrud() {
//    return new ModelAndView("crudAdminHome");
//}

// @GetMapping("/crudAdministradores")
//     public ModelAndView showAdmin(){
//         ModelAndView mv = new ModelAndView("crudAdmin");
//         return mv;
//     }

// @GetMapping("/crudAluno")
// public ModelAndView formCrudAluno(){
//     return new ModelAndView("crudAdminAluno");
// }
// @GetMapping("/crudCapitulos")
// public ModelAndView formCrudCapitulos(){
//     return new ModelAndView("crudAdminCapitulos");
// }

@GetMapping("/home")
public ModelAndView homeUsuario() {
    return new ModelAndView("homeUsuario");
}

@GetMapping("/crudEstatisticas")
    public ModelAndView CrudEstatisticas() {
    return new ModelAndView("crudAdminEstatisticas");
    }

@GetMapping("/capitulos")
public ModelAndView capitulos() {
    return new ModelAndView("capitulos");
}

@GetMapping("/fale-conosco")
public ModelAndView FaleConosco() {
    return new ModelAndView("faleconosco");
}
@GetMapping("/sobre-nos")
public ModelAndView SobreNos() {
    return new ModelAndView("sobrenos");
}

@GetMapping("/acessibilidade")
public ModelAndView acessibilidade() {
    return new ModelAndView("acessibilidade");
}

@GetMapping("/informacoes")
public ModelAndView InformacoesUsuario() {
    return new ModelAndView("informacoes");
}

@GetMapping("/cap1")
public ModelAndView MostraCap1(){
    return new ModelAndView("capitulos/cap1");
}

@GetMapping("/cap2")
public ModelAndView MostraCap2(){
    return new ModelAndView("capitulos/cap2");
}

@GetMapping("/cap3")
public ModelAndView MostraCap3(){
    return new ModelAndView("capitulos/cap3");
}

@GetMapping("/quiz1")
public ModelAndView MostraQuiz1(){
    return new ModelAndView("quiz/quiz1");
}

}