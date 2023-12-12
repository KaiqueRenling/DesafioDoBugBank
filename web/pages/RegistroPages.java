package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browser.Waits;


public class RegistroPages {

    private WebDriver driver;
    private Waits waits;

    public RegistroPages(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement tituloPrincipalDoBanco() {
        return waits.visibilityOfElement(By.xpath("//h1[normalize-space()='O banco com bugs e falhas do seu jeito']"));
    }

    public WebElement btnRegistrar() {
        return waits.visibilityOfElement(By.xpath("//button[text()='Registrar']"));
    }

    public WebElement inputCampoEmail() {
        return waits.visibilityOfElement(By.xpath("(//input[@placeholder='Informe seu e-mail'])[2]"));
    }

    public WebElement inputCampoNome() {
        return waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe seu Nome']"));
    }

    public WebElement inputCampoSenha() {
        return waits.visibilityOfElement(By.xpath("(//input[@placeholder='Informe sua senha' and @name='password'])[2]"));
    }

    public WebElement inputConfirmacaoSenha() {
        return waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe a confirmação da senha']"));
    }

    public WebElement contaComSaldoTrue() {
        return driver.findElement(By.xpath("//label[@id='toggleAddBalance']"));
    }

    public WebElement btnCadastrar() {
        return waits.visibilityOfElement(By.xpath("//button[text()='Cadastrar']"));
    }


    public WebElement btnFechar() {
        return waits.visibilityOfElement(By.xpath("//a[@id='btnCloseModal']"));
    }

    public WebElement txtContCriada() {
        return waits.visibilityOfElement(By.xpath("//p[@id='modalText']"));
    }



    public WebElement numeroDaConta() {
        return waits.visibilityOfElement(By.xpath("//p[@id='modalText']"));
    }
}
