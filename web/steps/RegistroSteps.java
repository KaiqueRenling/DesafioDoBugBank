package steps;

import interactions.RegistroInteractions;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import browser.TypeBrowser;
import browser.DriverManager;
import java.util.Properties;

public class RegistroSteps {


    private RegistroInteractions registroInteractions;
    private Properties properties;

    public RegistroSteps() {
        try {
            WebDriver driver = DriverManager.getDriver(TypeBrowser.CHROME);
            registroInteractions = new RegistroInteractions(driver);
        } catch (Exception e) {

            WebDriver driver = DriverManager.getDriver(TypeBrowser.FIREFOX);
            registroInteractions = new RegistroInteractions(driver);
        }
        properties = new Properties();
    }






    @Dado("que estou na pagina de inicio do Bug Bank")
    public void queEstouNaPaginaDeInicioDoBugBank() {
        String urlDoBanco = "https://bugbank.netlify.app/";
        registroInteractions.AcessarAPaginaInicialDoBugBank(urlDoBanco);
    }

    @E("clico em Registrar para a primeira conta")
    public void clicoEmRegistrarParaAPrimeiraConta() {
        registroInteractions.ClicarEmRegistrar();
    }

    @E("preencho os dados de registro corretamente para a primeira conta, informando {string}, {string}, {string} e {string}")
    public void preenchoOsDadosDeRegistroCorretamenteParaAPrimeiraContaInformandoEmailNomeSenhaEConfirmacaoSenha(String Email1, String Nome1, String Senha1, String ConfirmacaoSenha1) {
        registroInteractions.PreencherOsDadosDeRegistroParaPrimeiraConta(Email1, Nome1, Senha1, ConfirmacaoSenha1);
    }

    @E("seleciono criar conta com saldo para a primeira conta")
    public void selecionoCriarContaComSaldoTrueParaAPrimeiraConta() {
        registroInteractions.CriarContaComSaldo();
    }

    @E("clico no botao cadastrar para cadastrar a primeira conta")
    public void clicoNoBotaoCadastrarParaCadastrarAPrimeiraConta() {
        registroInteractions.ClicarEmCadastrar();
    }

    @Entao("deve aparecer a mensagem sinalizando que a primeira conta foi criada com sucesso")
    public void deveAparecerAMensagemSinalizandoQueAPrimeiraContaFoiCriadaComSucesso() {
        registroInteractions.ValidarACriacaoDaPrimeiraConta();
    }

    @Entao("deve aparecer a mensagem sinalizando que a segunda conta foi criada com sucesso")
    public void deveAparecerAMensagemSinalizandoQueASegundaContaFoiCriadaComSucesso() {
        registroInteractions.ValidarACriacaoDaSegundaConta();
    }

    @Dado("que clico no botão fechar")
    public void queClicoNoBotaoFechar() {
        registroInteractions.ClicarNoBotaoFechar();
    }

    @E("clico em Registrar para a segunda conta")
    public void clicoEmRegistrarParaASegundaConta() {
        registroInteractions.ClicarEmRegistrar();
    }

    @Quando("preencho os dados de registro corretamente para a segunda conta, informando {string}, {string}, {string} e {string}")
    public void preenchoOsDadosDeRegistroCorretamenteParaASegundaContaInformandoEmailNomeSenhaEConfirmacaoSenha(String Email2, String Nome2, String Senha2, String ConfirmacaoSenha2) {
        registroInteractions.PreencherOsDadosDeRegistroParaSegundaConta(Email2, Nome2, Senha2, ConfirmacaoSenha2);
    }



    @E("validar que a segunda conta tenha saldo")
    public void validarQueASegundaContaTenhaSaldo() {
        registroInteractions.ValidarQueASegundaContaTenhaSaldo();
    }

    @E("clico no botão cadastrar para cadastrar a segunda conta")
    public void clicoNoBotãoCadastrarParaCadastrarASegundaConta() {
        registroInteractions.ClicarEmCadastrar();
    }


}
