package com.fatec.fcmm.controller;
import java.util.Optional;

import javax.naming.Binding;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.fcmm.model.Cadastro;
import com.fatec.fcmm.services.MantemCadastro;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatec.fcmm.model.Usuario.Usuario;
import com.fatec.fcmm.model.Usuario.UsuarioDTO;
import com.fatec.fcmm.services.MantemUsuario;

import com.fatec.fcmm.model.Admin.Admin;
import com.fatec.fcmm.services.MantemAdmin;

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
MantemUsuario service;

Logger logger = LogManager.getLogger(this.getClass());

@GetMapping("/")
public ModelAndView menu() {
return new ModelAndView("index");
}

@GetMapping("/login")
public ModelAndView formLogin() {
    ModelAndView mv = new ModelAndView("login");
    
    return mv;
}

@PostMapping( value="/login-usuario", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public RedirectView login(@ModelAttribute @Valid UsuarioDTO  usuario, BindingResult result){
    

    Optional<Usuario> userEmail = service.findByEmail(usuario.getEmail());
    Optional<Usuario> userSenha = service.findBySenha(usuario.getSenha());
    
    logger.info(">>>>> Senha da requisicao: " + usuario.getSenha());
    logger.info(">>>>> Email da requisicaoo: " + usuario.getEmail());
    

    if (!userEmail.isEmpty() || !userSenha.isEmpty()){
        logger.info(">>>> Nada foi encontrado no banco");
        return new RedirectView("/login?vazio=true");
}else {
    try{
        Usuario User = userEmail.get();
        if (User.getSenha().equals(usuario.getSenha())){
            logger.info(">>>>> Email encontrado no banco de dados: " + usuario.getEmail());
            logger.info(">>>>> Senha correspondente: " + usuario.getSenha());
            return new RedirectView("/home");

        } else{
            logger.info(">>>>> Senha Incorreta para o email: " + usuario.getEmail());
        }
        
    } catch (Exception e){
        logger.info(">>>> ERRO " + e);
    }

    
    }
    return new RedirectView("/login?error=true");
}


@GetMapping("/crud")
public ModelAndView formCrud() {
    return new ModelAndView("crudAdminHome");
}

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