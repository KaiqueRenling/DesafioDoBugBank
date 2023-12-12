package steps;

import browser.DriverManager;
import browser.TypeBrowser;
import interactions.TransferenciaInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import utils.FilesOperation;

import java.io.IOException;
import java.util.Properties;

public class TransferenciaSteps{

    private TransferenciaInteractions transferenciaInteractions;
    private Properties properties; // Adicione uma variável para armazenar as propriedades

    public TransferenciaSteps() {
        try {
            WebDriver driver = DriverManager.getDriver(TypeBrowser.FIREFOX);
            transferenciaInteractions = new TransferenciaInteractions(driver);
        } catch (Exception e) {
            WebDriver driver = DriverManager.getDriver(TypeBrowser.CHROME);
            transferenciaInteractions = new TransferenciaInteractions(driver);
        }
        properties = new Properties(); // Inicialize a variável properties
    }

    @E("que valido o saldo para a primeira conta")
    public void validoOSaldoParaAPrimeiraConta() {
        transferenciaInteractions.SaldoConta1AntesDaTransferencia();
    }

    @Dado("que clico em transferencia")
    public void ClicoEmTransferencia() {
        transferenciaInteractions.ClicarEmTransferencia();
        
    }
    
    

    @Quando("preencho os dados para transferencia corretamente, informando a conta, digito, valor e descricao")
    public void preenchoOsDadosParaTransferenciaCorretamenteInformandoContaDigitoValorDescricao() {
        try {

            properties = FilesOperation.getProperties("conta");
            String numeroConta = properties.getProperty("numeroConta");
            String digitoConta = properties.getProperty("digitoConta");


            transferenciaInteractions.ContaEDigito(numeroConta, digitoConta);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler conta.properties: " + e.getMessage());
        }

        transferenciaInteractions.PreencherOsDadosDeTransferencia();
        transferenciaInteractions.ClicarEmTransferirAgora();
    }

    @Entao("deve aparecer a mensagem sinalizando que a transferencia de valor para a conta foi realizada com sucesso")
    public void deveAparecerAMensagemSinalizandoQueATransferenciaDeValorParaAContaFoiRealizadaComSucesso() {
        transferenciaInteractions.MensagemDeTransferenciaRealizadaComSucesso();
    }


    @Dado("que retorno a tela de inicio da primeira conta")
    public void queRetornoATelaDeInicioDaPrimeiraConta() {
        transferenciaInteractions.RetornarATelaInicialDaPrimeiraConta();
        
    }

    @Entao("deve aparecer o saldo corretamente para primeira conta")
    public void deveAparecerOSaldoCorretamenteParaPrimeiraConta() {
        transferenciaInteractions.SaldoDaPrimeiraConta();
        
    }

    @Dado("que estou na tela de inicio da segunda conta")
    public void queEstouNaTelaDeInicioDaSegundaConta() {
        transferenciaInteractions.TelaDeInicioDaSegundaConta();
        
    }

    @Entao("deve aparecer o saldo corretamente para a segunda conta")
    public void deveAparecerOSaldoCorretamenteParaASegundaConta() {
        transferenciaInteractions.SaldoDaSegundaaConta();

    }



}
