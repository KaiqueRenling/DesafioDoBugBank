package interactions;

import org.junit.Assert;
import org.openqa.selenium.*;
import pages.LoginPages;




public class LoginInteractions {

    private WebDriver driver;
    protected LoginPages loginPages;



    public LoginInteractions(WebDriver driver) {
        this.driver = driver;
        this.loginPages = new LoginPages(driver);
    }










    public void EstouNaTelaDeLogin() {
        String msgBemVindo = "O banco com bugs e falhas do seu jeito";
        Assert.assertEquals(msgBemVindo, loginPages.txtTelaDeLogin().getText().trim());


    }

    public void PreencherOsDadosDeLoginParaPrimeiraConta(String Email1, String Senha1) {
        loginPages.inputCampoEmailLogin().click();
        loginPages.inputCampoEmailLogin().clear();
        loginPages.inputCampoEmailLogin().sendKeys(Email1);

        loginPages.inputCampoSenhaLogin().click();
        loginPages.inputCampoSenhaLogin().clear();
        loginPages.inputCampoSenhaLogin().sendKeys(Senha1);

        loginPages.btnAcessar().click();
    }

    public void UsuarioLogadoComSucesso() {

        String msg = "bem vindo ao BugBank :)";
        Assert.assertEquals(msg, loginPages.txtUsuarioLogado().getText());

        System.out.println("O usuário foi logado com sucesso");


    }




    public void PreencherOsDadosDeLoginParaSegundaConta(String Email2, String Senha2) {
        loginPages.inputCampoEmailLogin().click();
        loginPages.inputCampoEmailLogin().clear();
        loginPages.inputCampoEmailLogin().sendKeys(Email2);

        loginPages.inputCampoSenhaLogin().click();
        loginPages.inputCampoSenhaLogin().clear();
        loginPages.inputCampoSenhaLogin().sendKeys(Senha2);

        loginPages.btnAcessar().click();
    }

    public void SairDaPrimeiraConta() {
        loginPages.btnSairDaConta().click();
    }
}
