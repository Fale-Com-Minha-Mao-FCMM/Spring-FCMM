//const justValidateProductionMin = require("./justValidate/just-validate.production.min.js");

console.log("Testando validation")

const validar = new JustValidate('#cadastro-usuario'); 

    //Validação de Email
    validar.addField( '#inputEmail' , [
        { rule: 'required' , errorMessage: 'O campo e-mail é obrigatório'},
        { rule: 'email' ,  errorMessage: 'E-mail inválido.'}
    ])
    .addField( ' #inputConfirmaEmail '  , [
        {
            rule: 'required', errorMessage: 'O campo confirma e-mail é obrigatório'
        },
        {
            validar: (value, fields) =>{
                if (
                    fields[ ' #inputEmail ' ] &&
                    fields[ ' #inputEmail ' ] . elem
                ) {
                    const inputConfirmaEmail = 
                    fields [ ' #inputConfirmaEmail ' ].elem.value;

                    return value === inputConfirmaEmail;
                }
                return true;
            },
            errorMessage: 'Os emails não coencidem.',
        },
    ])

    //Validação de Senha
    validar.addField( ' #inputSenha ', [
        { rule: ' required ', errorMessage: ' O campo senha é obrigatório' },
        { rule: 'strongPassword' , value: '8' , errorMessage: ' A senha deve conter no mínimo 8 caracteres '  }
    ])
    .addField( ' #inputConfirmaSenha ' , [
        { 
            rule: 'required' ,
        },
        {
            validar: (value, fields) => {
                if (
                    fields [ '#inputSenha' ] &&
                    fields [ '#inputSenha' ].elem
                ){
                    const inputConfirmaEmail = 
                    fields [ ' #inputConfirmaSenha '] .elem.value;

                    return value === inputConfirmaEmail
          a      }
                return true;
            },
            errorMessage: 'As senhas não coecidem.'
        }
    ])

    validar.addField( '#inputNumeroCelular', [
        { rule: ' required ', errorMessage: ' O campo Telefone é obrigatório ' }
    ])

// const inputRules= {
//     inputName: [
//         { rule: 'required' ,  errorMessage: 'O campo nome é obrigatório' },
//         { rule: 'minLenght' , value: '3' , errorMessage: 'O campo nome deve conter no mínimo 3  caracteres' }
//     ],

//     inputSobrenome: [
//         { rule: 'required' ,  errorMessage: 'O campo sobrenome é obrigatório' },
//         { rule: 'minLenght' , value: '3' , errorMessage: 'O campo nome deve conter no mínimo 3 caracteres' }
//     ],

//     inputNumeroCelular: [
//         { rule: 'required' , errorMessage: 'O campo telefone é obrigatório'},
//         { rule: 'minLenght'  , value: '13' , errorMessage: 'O campo telefone está incompleto' },
//         { rule: 'maxLenght' , value: '13' , errorMessage: 'O campo telefone está ultrapassando o número de caracteres'}
//     ],

//     inputEmail: [
//         { rule: 'required' , errorMessage: 'O campo e-mail é obrigatório'},
//         { rule: 'email' ,  errorMessage: 'E-mail inválido.'}
//     ],

//     inputConfirmaEmail [
//         { rule: 'required' , errorMessage: 'O campo confirmar email é obrigatório'},
//         {
//             validator : (value, fields) => {
//                 if (
//                     fields [ ' inputEmail ' ] &&
//                     fields [ ' inputEmail ' ].elem
//                  ) {
//                     const repetirEmail = 
//                     fields [ ' inputEmail ' ].elem.value;

//                     return value === repetirEmail;
//                  }

//                  return true;
//             },
//             errorMessage: ' Os emails estão divergentes ',
//         }
//     ]

// }


// function validarCampos(){

//     let nome = document.getElementById('nome');
//     let email = document.getElementById('email');
//     let senha = document.getElementById('senha');
//     let confirmar = document.getElementById('confirmar');

//     if (nome.value == ""){
//         Swal.fire({
//             icon:'error',
//             title: 'Campo nome vazio',
//             text: 'Por favor, preencha o campo "nome" corretamente.'
//         })
//         nome.focus();
//         return false;
//     }

//     if (email.value == ""){
//         Swal.fire({
//             icon: 'error',
//             title: 'Campo email vazio',
//             text: 'Por favor, preencha o campo "e-mail" corretamente.'
//         })
//         email.focus();
//         return false;
//     }

//     if (senha.value == ""){
//         Swal.fire({
//             icon: 'error',
//             title: 'Campo senha vazio',
//             text: 'Por favor, preencha o campo "senha" corretamente.'
//         })
//         email.focus();
//         return false;
//     }

//     if (confirmar.value != senha.value){
//         Swal.fire({
//             icon: 'error',
//             title: 'Senhas não confirmam',
//             text: 'As senhas estão diferentes, favor preencher corretamente' 
//         })
//         confirmar.focus();
//         return false;
//     }

//     let regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{6,16}$/
//     if (!regex.exec(senha.value)){
//         Swal.fire({
//             icon: 'error',
//             title: 'Senha inválida',
//             text: 'A senha deve conter entre 6 a 16 caracteres sendo pelo menos 1 letra maiúsula e 1 minúscula, 1 numero e 1 caractere especial.'
//         })
//         senha.focus()
//         return false
//     }
// }

// function validarLogin(){

//     let email = document.getElementById('email');
//     let senha = document.getElementById('senha');

//     if (email.value == ""){
//         Swal.fire({
//             icon: 'error',
//             title: 'Campo email vazio',
//             text: 'Por favor, preencha o campo "e-mail" corretamente.'
//         })
//         email.focus();
//         return false;
//     }

//     if (senha.value == ""){
//         Swal.fire({
//             icon: 'error',
//             title: 'Campo senha vazio',
//             text: 'Por favor, preencha o campo "senha" corretamente.'
//         })
//         email.focus();
//         return false;
//     }

//     let regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{6,16}$/
//     if (!regex.exec(senha.value)){
//         Swal.fire({
//             icon: 'error',
//             title: 'Senha inválida',
//             text: 'A senha deve conter entre 6 a 16 caracteres sendo pelo menos 1 letra maiúsula e 1 minúscula, 1 numero e 1 caractere especial.'
//         })
//         senha.focus()
//         return false
//     }
// }