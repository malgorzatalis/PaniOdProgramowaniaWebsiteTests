package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By titleLocator = By.tagName("h1");
    private final By svgLocator = By.cssSelector(".t.k");
    private final By cookieAcceptButton = By.cssSelector("#__next button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Inicjalizacja WebDriverWait
    }

    public Boolean isDisplayed() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(svgLocator));
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element SVG nie jest wyświetlany: " + e.getMessage());
            return false;
        }
    }

    public String getTitle() {
        try {
            WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
            return titleElement.getText();
        } catch (NoSuchElementException e) {
            return "Title not found";
        }
    }

    public void clickCookieAcceptButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            button.click();
            System.out.println("Kliknięto przycisk akceptacji ciasteczek.");
        } catch (Exception e) {
            System.out.println("Nie znaleziono lub nie można kliknąć przycisku akceptacji ciasteczek: " + e.getMessage());
        }
    }
}
