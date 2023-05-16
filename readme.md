# Fala com Minha Mão

## Fatec ZL - Centro Paula Souza
#### Disciplina - Programação Web III

Grupo FCMMM - Fale com as Minhas Mãos
- Gabriel da Silva Oliveira dos Santos
- Giovanna Passos Figueira da Silva
- Karoline de Souza da Silva

##### Objetivo – FCMM 
> O objetivo da Equipe FCMM é construir uma aplicação capaz de ensinar ao usuário, de forma gamificada, o básico da linguagem de sinais a fins de expandir a comunicação para deficientes verbais e auditivos e facilitar a inclusão dos mesmos na sociedade

#### Utilizar os recursos ideais!
> Uma vez que encontramos a necessidade e a carência da comunidade em meio a sociedade, será necessário aplicar o projeto de forma leve e acessível.
Portanto, na construção do projeto a definição das ferramentas utilizadas terá que ser precisa! Desde a linguagem de programação para o front e back-end, até as API’s, integração com o banco de dados e demais informações.
Por ser um projeto acadêmico, devemos utilizar da nossa ideia inovadora, um meio de aprendizagem para evoluirmos nossos conhecimentos, aprendendo com os erros e não os cometendo novamente.

#### Da onde surgiu o FCMM?

> A principio a ideia foi gerada dentro de um grupo de TCC na Etec Zona Leste, a mesma ideia teve um início de desenvolvimento, mas nada muito concreto e profundo, apenas uma idéia abstrada.
O Projeto tem um código incompleto e um protótipo pré-definido, mas com certeza está sujeito a alterações.
Dessa forma, um dos nossos objetivos é expandir o projeto para outras universidades e empresas, pois uma das integrantes do TCC hoje é estudante da Intelli, e outro já está em uma empresa na aérea do desenvolvimento.

##### Sprint Backlog
> Cada requisito tem um identificador único de maneira que seja possível rastrear a necessidade do cliente com a implementação do software. 
> #### Identificador - Descrição - Prioridade
>- ##### REQ01
>O sistema deve permitir o usuário a realizar o cadastro no site utilizando um nome,email e senha de preferência (Média)  
>- #### REQ02 
>O sistema deve iniciar o cadastro de um novo usuário no nível 01.
>- #### REQ03 
>O sistema deve permitir que o usuário realize login e visualize as sessões do site, comoas informações sobre os >desenvolvedores, tela de acessibilidade, curso, seu nome eseu nível.
>- #### REQ04
>O sistema deve liberar os capítulos do curso ao usuário de acordo com o seu nível.
>- #### REQ05 
>O sistema deve apresentar o capítulo para o usuário usando o material, referencias eum quiz de finalização.
>- #### REQ06
>O sistema deve subir o nível do usuário ao ele completar um capítulo do cursocorretamente.
>- #### REQ07
>O sistema deve validar um capítulo concluído apenas quando o usuário respondercorretamente um número específico de >questões.

##### Definição de pronto
> O sprint será considerado concluido quando:
> 1) Os casos de teste de aceitação forem executados e obtiverem 100% de satisfatorios. Os casos de teste (CT) são rastreáveis para os requisiitos (REQ). O elo de rastreabilidade
é estabelecido pelo identificador do caso de teste.
> 2) Depois de executado os casos de teste com 100% de satisfatorios o código deve ser armazenado no github (commit).

#### Linguagens Front - End
<div style="display: inline_block"><br>
  <img align="center" alt="HTML" height="50" width="60"
  src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" <br>
  <img align="center" alt="CSS" height="50" width="60"
  src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" <br>
  <img align="center" alt="Java Script" height="50" width="60"
  src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" <br>
  
  <br>
  
  
#### Linguagens Back - End
<div style="display: inline_block"><br>
  <img align="center" alt="Java" height="50" width="60" 
  src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/php/php-plain.svg"<br>
  <img align="center" alt="Java" height="50" width="60" 
src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" 
<br>


#### Modelo de Domínio
> O modelo de dominio (Larman, 2006 - classes conceituais ou classes de negócio) foi definido considerando as seguintes classes:
![Diagrama em branco - ED02 PW (1)](https://user-images.githubusercontent.com/99614357/226621601-2bbac522-7373-4c23-afbc-e3cb5741e0aa.png)


>Referencias
- [1] KRUCHTEN, Philippe. Reference: Title: Architectural blueprints—the “4+ 1” view model of software architecture. IEEE software, v. 12, n. 6, 1995.
- [2] RICHARDSON, Chris. Microservices patterns: with examples in Java. Simon and Schuster, 2018.
- [3] ERL, Thomas. SOA principles of service design (the Prentice Hall service-oriented computing series from Thomas Erl). Prentice Hall PTR, 2007.
- [4] LARMAN, Craig. Utilizando UML e padrões. 2aed., Porto Alegre: Bookman Editora, 2006 (pag. 147).

## Como fazer push no repositório.

Primeiro é necessario realizar o login no github, devendo do git clone que você for dar, poderá pedir o seu token, então se for preciso, crie um.

```bash
# Clone no Projeto
$ git clone https://github.com/Fale-Com-Minha-Mao-FCMM/Spring-Fcmm.git

# Logue no GitHub!
$ git config --global user.email "seu@email.com"
$ git config --global user.name "seuNome"

# Verifique o commit
$ git status

# Adicione os arquivos modificados
$ git add . 

# Dê o commit
$ git commit -m "mensagem com coisas"

# Agora é só dar o push
$ git push origin main

```
