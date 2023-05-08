function validar(event){

    document.getElementsByClassName
    
    var email = document.getElementById("inputEmail").value
    var confirmaEmail = document.getElementById("inputConfirmaEmail").value

    if(email != confirmaEmail){
        alert("Os endereços de email não correspondem.");
        return false;
    }
    
    if(email == ""){
        alert("Por favor, insira um email.")
        cadastro.inputEmail.focus();
        return false;
    }

    if(confirmarEmail == ""){
        alert("Por favor, confirma seu email.")
        cadastro.inputConfirmaEmail.focus();
        return false;
    }

    if (senha == ""){
        alert("Por favor, insira uma senha válida.")
        cadastro.inputSenha.focus();
        return false;
    }

    if(confirmaSenha == ""){
        alert("Por favor, confirma sua senha.")
        cadastro.inputConfirmaSenha.focus();
        return false;
    }

    if (nome == ""){
        alert("Por favor, não deixe o campo nome vazio.")
        cadastro.inputName.focus();
        return false;
    }

    if (sobrenome == ""){
        alert("Por favor, não deixe o campo sobrenome vazio.")
        cadastro.inputSobrenome.focus();
        return false;
    }

    
    if (numero == ""){
        alert("Por favor, preencha seu número de telefone.")
        cadastro.inputNumeroCelular.focus();
        return false;
    }
    
    if (data == ""){
        alert("Por favor, informe sua data de nascimento.")
        cadastro.inputDataAniversario.focus();
        return false;
    }
    
    if (termos == false){
        alert("Por favor, aceite os termos de condições para prosseguir..")
        cadastro.termosCondicoes.focus();
        return false;
    }

    if (email != confirmarEmail){
        alert("Seus emails não coincidem")
        cadastro.confirmarEmail.focus();
        return false;
    }

    if (senha != confirmaSenha){
        alert("Suas senhas não coincidem")
        cadastro.confirmaSenha.focus();
        return false;
    }
    
    let regex = /^(?=.*?[A-Za-z0-9_])(?=.*?[^\w\s]).{6,10}$/

    /*(?=.*?[A-Z]) - minimo uma letra maiscula.
     (?=.*?[a-z]) - minimo uma letra minuscula.
     (?=.*?[0-9]) - minimo de número.
     (?=.*?[^\w\s]) - minimo de caractere especial.
     .{6.10} - minimo 6, maximo 10 caracteres. */
    
    if(!regex.exec(senha)){
        alert("Senha de uma letra maiuscula, uma minuscula, um numero, um caractere especial");
        cadastro.inputSenha.focus();
        return false;
        
    }

    const deleteBtn = event.target

    let url = deleteBtn.href.split('/')
    url = url.filter(Boolean)[2]  // 0º(http)://1º(host)/2º(objective)/3º(id)
    url = '/' + url

    const id = deleteBtn.href.charAt(deleteBtn.href.length - 1)

    window.location.href = `${url}/${id}`

    return true;


}