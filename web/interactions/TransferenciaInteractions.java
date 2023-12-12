package interactions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TransferenciaPages;
import utils.FilesOperation;

import java.io.IOException;

public class TransferenciaInteractions {

    private WebDriver driver;
    protected  TransferenciaPages transferenciaPages;

    private String saldoContaAtualizado1;
    private String saldoContaAtualizado2;

    public TransferenciaInteractions(WebDriver driver) {
        this.driver = driver;
        this.transferenciaPages = new TransferenciaPages(driver);
    }






    public String SaldoConta1AntesDaTransferencia() {
        WebElement saldoElement = transferenciaPages.getSaldoDaConta1();
        String saldoAntes = saldoElement.getText();
        System.out.println("Saldo inicial da conta 1: " + saldoAntes);
        return saldoAntes;
    }




    public void ClicarEmTransferencia() {
        transferenciaPages.btnTransferencia().click();

    }

    public void ContaEDigito(String conta, String digito) {
        transferenciaPages.digitarNumeroDaConta(conta);
        transferenciaPages.digitarNumeroDoDigito(digito);
    }


    public void PreencherOsDadosDeTransferencia() {


        transferenciaPages.inputValorDeTransferencia().click();
        transferenciaPages.inputValorDeTransferencia().sendKeys("1000");

        transferenciaPages.inputDescricao().sendKeys("Segue a transferência realizada para a conta");
        transferenciaPages.inputDescricao().click();


    }

    public void ClicarEmTransferirAgora() {
        transferenciaPages.btnTransferirAgora().click();
    }



    public void MensagemDeTransferenciaRealizadaComSucesso() {
        String MensagemTransferenciaRealizadaComSucesso = "Transferencia realizada com sucesso";
        Assert.assertEquals(MensagemTransferenciaRealizadaComSucesso, transferenciaPages.txtTransferenciaComSucesso().getText().trim());

        System.out.println("Transferência para a conta 2 realizada com sucesso");
    }

    public void RetornarATelaInicialDaPrimeiraConta() {
        transferenciaPages.btnFecharTransferencia().click();
        transferenciaPages.btnVoltarParaTelaInialDaConta().click();
    }


    public void SaldoDaPrimeiraConta() {
        WebElement saldoElement = transferenciaPages.getSaldoDaConta1();
        String saldo = saldoElement.getText();

        try {

            FilesOperation.setSaldo("1", saldo);
            saldoContaAtualizado1 = saldo;

            System.out.println("Saldo da conta 1 atualizada, após a Transferência: " + saldo);
        } catch (IOException e) {
            System.err.println("Erro ao atualizar o saldo: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }





    public void TelaDeInicioDaSegundaConta() {
        String TelaDeInicioDaSegundaConta = "bem vindo ao BugBank :)";
        Assert.assertEquals(TelaDeInicioDaSegundaConta, transferenciaPages.txtBoasVindasParaSegundaConta().getText().trim());

    }

    public void SaldoDaSegundaaConta() {

        WebElement saldoElement = transferenciaPages.getSaldoDaConta2();
        String saldo = saldoElement.getText();

        try {
            FilesOperation.setSaldo("2", saldo);
            saldoContaAtualizado2 = saldo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saldo da conta 2 atualizado, após a transferência: " + saldo);
    }















}



