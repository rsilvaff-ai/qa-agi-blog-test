package steps;

import io.cucumber.java.pt.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;

public class SearchSteps {

    WebDriver driver;
    SearchPage searchPage;

    @Dado("que o usuário acessa o Blog do Agi")
    public void acessar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        searchPage.acessarSite();
    }

    @Quando("o usuário busca por {string}")
    public void buscar(String termo) {
        searchPage.buscar(termo);
    }

    @Então("deve visualizar resultados")
    public void validarResultados() {
        Assert.assertTrue(searchPage.obterResultados() > 0);
        driver.quit();
    }

    @Então("não deve haver resultados")
    public void validarSemResultados() {
        Assert.assertTrue(searchPage.obterResultados() == 0);
        driver.quit();
    }
}