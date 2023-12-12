package pages;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TransferenciaPages {

    private WebDriver driver;
    private Waits waits;

    public TransferenciaPages(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver); // Inicialize waits com o driver
    }




    public WebElement txtBoasVindasParaSegundaConta() {
        return waits.visibilityOfElement(By.xpath("//p[contains(text(), 'bem vindo ao BugBank :)')]"));
    }

    public WebElement btnTransferencia() {
        return waits.visibilityOfElement(By.xpath("//a[@id='btn-TRANSFERÊNCIA']"));
    }


    public void digitarNumeroDaConta(String conta) {
        WebElement inputNumeroDaConta = waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe o número da conta']"));
        inputNumeroDaConta.sendKeys(conta);
    }


    public void digitarNumeroDoDigito(String digito) {
        WebElement inputDigitoConta = waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe o dígito da conta']"));
        inputDigitoConta.sendKeys(digito);
    }



    public WebElement inputValorDeTransferencia() {
        return waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe o valor da transferência']"));
    }

    public WebElement inputDescricao() {
        return waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe uma descrição']"));
    }

    public WebElement btnTransferirAgora() {
        return waits.visibilityOfElement(By.xpath("//button[contains(text(), 'Transferir agora')]"));
    }

    public WebElement txtTransferenciaComSucesso() {
        return waits.visibilityOfElement(By.xpath("//p[contains(text(), 'Transferencia realizada com sucesso')]"));
    }

    public WebElement btnFecharTransferencia() {
        return waits.visibilityOfElement(By.xpath("//a[@id='btnCloseModal']"));
    }

    public WebElement btnVoltarParaTelaInialDaConta() {
        return waits.visibilityOfElement(By.xpath("//a[@id='btnBack']"));
    }

    public WebElement getSaldoDaConta1() {
        return waits.visibilityOfElement(By.xpath("//*[@id='textBalance']/span"));
    }

    public WebElement getSaldoDaConta2() {
        return waits.visibilityOfElement(By.xpath("//*[@id='textBalance']/span"));
    }




}
