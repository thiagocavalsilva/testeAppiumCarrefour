package Passos;

import io.cucumber.java.DataTableType;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import LoginPaginas.LoginPaginas;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LoginPassos {

    private LoginPaginas loginPaginas;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

    @Dado("que estou na pagina de login")
    public void queEstouNaPaginaDeLogin() {
        loginPaginas = new LoginPaginas();
    }

    @Dado("que acesso a pagina de login")
    public void queAcessoAPaginaDeLogin() {
        loginPaginas = new LoginPaginas();
    }

    @Quando("^clico em \"?Sign Up\"?$")
    public void clicoEmSignUp() {
        loginPaginas.loginbtnpage.click();
        loginPaginas.clickToSignUp();
    }

    @Quando("preencho os {word}")
    public void preenchoOsCamposOuDados(String palavra, Map<String, String> map) {
        // casa com "preencho os campos" ou "preencho os dados"
        String email = map.get("email");
        String senha = map.get("senha");
        loginPaginas.realizarCadastro(email, senha);
    }

    @Entao("confirmo que a conta foi criada")
    public void confirmoQueAContaFoiCriada() {
        loginPaginas.clickToConfirmSignUp();
        String signupMessage = loginPaginas.getTxtAndroidPopup();
        assertEquals("You successfully signed up!", signupMessage);
    }

    @Quando("realizo o login com os seguintes dados")
    public void realizoOLoginComOsSeguintesDados(Map<String, String> map) {
        String email = map.get("email");
        String senha = map.get("senha");
        loginPaginas.realizarLogin(email, senha);
    }

    // alias para compatibilidade com features antigas
    @Quando("for realizado login com os seguintes dados")
    public void forRealizadoLoginComOsSeguintesDados(Map<String, String> map) {
        realizoOLoginComOsSeguintesDados(map);
    }

    @Entao("valido que e exibido o popup de sucesso")
    public void validoQueEExibidoOPopupDeSucesso() {
        String loggedMessage = loginPaginas.getTxtAndroidPopup();
        assertEquals("You are logged in!", loggedMessage);
    }

    @Entao("valido que no campo de erro de email e exibida a mensagem {string}")
    public void validoQueNoCampoErroEmailExibeAMensagem(String mensagemEsperada) {
        String mensagemAtual = loginPaginas.getTxtNotAuthEmail();
        assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Entao("valido que no campo de erro de senha e exibida a mensagem {string}")
    public void validoQueNoCampoErroSenhaExibeAMensagem(String mensagemEsperada) {
        String mensagemAtual = loginPaginas.getTxtNotAuthPassword();
        assertEquals(mensagemEsperada, mensagemAtual);
    }
}
