package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SearchSteps {

    WebDriver driver;

    @Dado("que o usuário acessa o Blog do Agi")
    public void que_o_usuario_acessa_o_blog_do_agi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blog.agi.com.br"); 
    }

    @Quando("o usuário busca por {string}")
    public void o_usuario_busca_por(String termo) {
    // 1. Clicar na lupa para abrir o campo de busca
        WebElement lupa = driver.findElement(By.cssSelector("span.menu-text"));
        lupa.click();
    // 2. Esperar o campo de busca ficar visível
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-field")));
    // 3. Digitar o termo e pressionar Enter
        searchInput.clear();
        searchInput.sendKeys(termo + Keys.ENTER);
}

    @Entao("deve visualizar resultados")
    public void deve_visualizar_resultados() {
        WebElement results = driver.findElement(By.cssSelector(".search-results")); 
        assertTrue(results.isDisplayed());
        driver.quit();
    }

    @Entao("não deve haver resultados")
    public void nao_deve_haver_resultados() {
        WebElement results = driver.findElement(By.cssSelector(".search-results"));
        assertFalse(results.isDisplayed());
        driver.quit();
    }
}
