package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browser.Waits;


public class LoginPages  {

    private WebDriver driver;
    private Waits waits; // Adicione a variável waits

    public LoginPages(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    public WebElement inputCampoEmailLogin() {
        return waits.visibilityOfElement(By.xpath("(//input[@placeholder='Informe seu e-mail'])[1]"));
    }

    public WebElement inputCampoSenhaLogin() {
        return waits.visibilityOfElement(By.xpath("(//input[@placeholder='Informe sua senha'])[1]"));
    }

    public WebElement btnAcessar() {
        return waits.visibilityOfElement(By.xpath("//button[contains(text(), 'Acessar')]"));
    }

    public WebElement txtUsuarioLogado() {
        return waits.visibilityOfElement(By.xpath("//p[contains(text(), 'bem vindo ao BugBank :)')]"));
    }


    public WebElement txtTelaDeLogin() {
        return waits.visibilityOfElement(By.xpath("//h1[contains(text(), 'O banco com bugs e falhas do seu jeito')]"));
    }



    public WebElement btnSairDaConta() {
        return waits.visibilityOfElement(By.xpath("//a[@id='btnExit']"));
    }



}
