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
        driver.get("https://blog.agi.com.br"); // Ajuste para o URL correto do blog
    }

    @Quando("o usuário busca por {string}")
    public void o_usuario_busca_por(String termo) {
        WebElement searchInput = driver.findElement(By.name("s")); // Ajuste se o campo tiver outro name
        searchInput.sendKeys(termo);
        searchInput.submit();
    }

    @Entao("deve visualizar resultados")
    public void deve_visualizar_resultados() {
        WebElement results = driver.findElement(By.cssSelector(".search-results")); // Ajuste se necessário
        assertTrue(results.isDisplayed());
        driver.quit();
    }

    @Entao("não deve haver resultados")
    public void nao_deve_haver_resultados() {
        WebElement results = driver.findElement(By.cssSelector(".search-results")); // Ajuste se necessário
        assertFalse(results.isDisplayed());
        driver.quit();
    }
}