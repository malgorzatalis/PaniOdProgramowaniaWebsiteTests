package pl.paniodprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsletterBannerPage extends BasePage {

    public NewsletterBannerPage(WebDriver driver) {
        super(driver);
    }

    private final By closeBtn = By.cssSelector("button.ml-popup-close\n");

    @Override
    public boolean isLoaded() {
        return !driver.findElements(closeBtn).isEmpty();
    }

    public boolean closeIfVisibile() {
        if (isLoaded()) {
            click(closeBtn);
            return true;
        }
        return false;
    }
}
