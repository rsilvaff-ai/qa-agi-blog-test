package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    By searchButton = By.cssSelector("button.search-toggle");
    By searchInput = By.cssSelector("input[type='search']");
    By results = By.cssSelector(".post-item");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarSite() {
        driver.get("https://blogdoagi.com.br/");
    }

    public void buscar(String termo) {
        driver.findElement(searchButton).click();
        driver.findElement(searchInput).sendKeys(termo);
        driver.findElement(searchInput).submit();
    }

    public int obterResultados() {
        return driver.findElements(results).size();
    }
}