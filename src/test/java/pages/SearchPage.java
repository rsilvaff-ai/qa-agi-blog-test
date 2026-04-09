package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchButton = By.cssSelector("button.search-toggle");
    By searchInput = By.cssSelector("input[type='search']");
    By results = By.cssSelector(".post-item");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void acessarSite() {
        driver.get("https://blogdoagi.com.br/");
    }

    public void buscar(String termo) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        btn.click();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.sendKeys(termo);
        input.submit();
    }

    public int obterResultados() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(results));
        List<WebElement> lista = driver.findElements(results);
        return lista.size();
    }
}