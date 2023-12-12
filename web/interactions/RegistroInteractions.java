package interactions;



import org.junit.Assert;
import pages.RegistroPages;
import utils.FilesOperation;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

public class RegistroInteractions {


    private WebDriver driver;

    protected  RegistroPages registroPages;
    private String urlDoBanco = "https://bugbank.netlify.app/";

    public RegistroInteractions(WebDriver driver) {
        this.driver = driver;
        this.registroPages = new RegistroPages(driver);
    }







    public void AcessarAPaginaInicialDoBugBank(String url) {
        urlDoBanco = url;
        driver.get(url);


        Assert.assertNotNull(registroPages);

        String PaginaDeInicio = "O banco com bugs e falhas do seu jeito";
        Assert.assertEquals(PaginaDeInicio, registroPages.tituloPrincipalDoBanco().getText().trim());
    }

    public void ClicarEmRegistrar() {
        registroPages.btnRegistrar().click();
    }

    public void PreencherOsDadosDeRegistroParaPrimeiraConta(String Email1, String Nome1, String Senha1, String ConfirmacaoSenha1) {
        registroPages.inputCampoEmail().click();
        registroPages.inputCampoEmail().sendKeys(Email1);

        registroPages.inputCampoNome().click();
        registroPages.inputCampoNome().sendKeys(Nome1);

        registroPages.inputCampoSenha().click();
        registroPages.inputCampoSenha().sendKeys(Senha1);

        registroPages.inputConfirmacaoSenha().click();
        registroPages.inputConfirmacaoSenha().sendKeys(ConfirmacaoSenha1);


    }

    public void CriarContaComSaldo() {
        registroPages.contaComSaldoTrue().click();
    }

    public void ClicarEmCadastrar() {
        registroPages.btnCadastrar().click();
    }

    public void ValidarACriacaoDaPrimeiraConta() {

        String mensagemEsperada = "criada com sucesso";
        String mensagemAtual = registroPages.txtContCriada().getText().trim();

        Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));






    }

    public void ClicarNoBotaoFechar() {
        registroPages.btnFechar().click();
    }

    public void PreencherOsDadosDeRegistroParaSegundaConta(String Email2, String Nome2, String Senha2, String ConfirmacaoSenha2) {
        registroPages.inputCampoEmail().click();
        registroPages.inputCampoEmail().clear();
        registroPages.inputCampoEmail().sendKeys(Email2);

        registroPages.inputCampoNome().click();
        registroPages.inputCampoNome().clear();
        registroPages.inputCampoNome().sendKeys(Nome2);

        registroPages.inputCampoSenha().click();
        registroPages.inputCampoSenha().clear();
        registroPages.inputCampoSenha().sendKeys(Senha2);

        registroPages.inputConfirmacaoSenha().click();
        registroPages.inputConfirmacaoSenha().clear();
        registroPages.inputConfirmacaoSenha().sendKeys(ConfirmacaoSenha2);
    }

    public void ValidarQueASegundaContaTenhaSaldo() {
        registroPages.contaComSaldoTrue().click();
        registroPages.contaComSaldoTrue().click();
    }




    public void ValidarACriacaoDaSegundaConta() {
        String mensagemEsperada = "criada com sucesso";
        String mensagemAtual = registroPages.txtContCriada().getText().trim();

        Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));

        String numeroDaConta = registroPages.numeroDaConta().getText();
        String[] splitNumeroDaConta = numeroDaConta.split("-");

        String numeroDaContaFormatado = splitNumeroDaConta[0].replaceAll("[^0-9]", "");
        String digitoDaConta = splitNumeroDaConta[1].replaceAll("[^0-9]", "");
        try {
            FilesOperation.setProperty("conta", "numeroConta", numeroDaContaFormatado);
            FilesOperation.setProperty("conta", "digitoConta", digitoDaConta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }




}
