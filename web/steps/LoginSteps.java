package steps;

import browser.DriverManager;
import browser.TypeBrowser;
import interactions.LoginInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginSteps {

    private LoginInteractions loginInteractions;
    private Properties properties;

    public LoginSteps() {
        try {
            WebDriver driver = DriverManager.getDriver(TypeBrowser.CHROME);
            loginInteractions = new LoginInteractions(driver);
        } catch (Exception e) {
            // Caso falhe ao obter o driver do Chrome, tenta com o Firefox
            WebDriver driver = DriverManager.getDriver(TypeBrowser.FIREFOX);
            loginInteractions = new LoginInteractions(driver);
        }
        properties = new Properties(); // Inicialize a variável properties
    }

    @Dado("que estou na tela de login do Bug Bank")
    public void queEstouNaTelaDeLoginDoBugBank() {

        loginInteractions.EstouNaTelaDeLogin();
    }

    @Quando("preencho os dados de login corretamente para a primeira conta, informando {string} e {string}")
    public void preenchoOsDadosDeLoginCorretamenteParaAPrimeiraContaInformandoEmailESenha(String Email1, String Senha1) {
        loginInteractions.PreencherOsDadosDeLoginParaPrimeiraConta(Email1, Senha1 );

    }

    @Entao("o usuario deve ser logado com sucesso")
    public void oUsuarioDeveSerLogadoComSucesso() {

        loginInteractions.UsuarioLogadoComSucesso();
    }
    @Dado("que estou na primeira conta")
    public void queEstouNaPrimeiraConta() {

    }



    @Quando("preencho os dados de login corretamente para a segunda conta, informando {string} e {string}")
    public void preenchoOsDadosDeLoginCorretamenteParaASegundaContaInformandoEmailESenha(String Email2, String Senha2) {
        loginInteractions.PreencherOsDadosDeLoginParaSegundaConta(Email2, Senha2);
    }

    @Dado("clico em sair")
    public void clicoEmSair() {
        loginInteractions.SairDaPrimeiraConta();
    }


}
