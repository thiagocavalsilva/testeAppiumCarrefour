# language: pt
@login
Funcionalidade: Login

  @1
  Cenario: Criar conta com dados validos
    Dado que acesso a pagina de login
    Quando clico em Sign Up
    E preencho os campos:
      | email | thiago@qa.com |
      | senha | 12345678      |
    Entao confirmo que a conta foi criada

  Cenario: Efetuar login com credenciais validas
    Dado que estou na pagina de login
    Quando realizo o login com os seguintes dados
      | email | thiago@qa.com |
      | senha | 12345678      |
    Entao valido que e exibido o popup de sucesso

  Esquema do Cenario: Login com <cenario> (validacao de email)
    Dado que estou na pagina de login
    Quando realizo o login com os seguintes dados
      | email | <email> |
      | senha | <senha> |
    Entao valido que no campo de erro de email e exibida a mensagem "<msg>"
    Exemplos:
      | cenario             | email   | senha  | msg                               |
      | com email invalido  | teste   | 123456 | Please enter a valid email address |
      | com email em branco | [blank] | 123456 | Please enter a valid email address |

  Esquema do Cenario: Login com <cenario> (validacao de senha)
    Dado que estou na pagina de login
    Quando realizo o login com os seguintes dados
      | email | <email> |
      | senha | <senha> |
    Entao valido que no campo de erro de senha e exibida a mensagem "<msg>"
    Exemplos:
      | cenario             | email          | senha   | msg                                |
      | com senha invalida  | thiago@qa.com  | 123     | Please enter at least 8 characters |
      | com senha em branco | thiago@qa.com  | [blank] | Please enter at least 8 characters |
