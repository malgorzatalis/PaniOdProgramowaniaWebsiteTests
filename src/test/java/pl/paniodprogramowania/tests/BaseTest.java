package pl.paniodprogramowania.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.paniodprogramowania.pages.BasePage;


public class BaseTest {
    protected static WebDriver driver;
    protected BasePage basePage;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDownAll() {
        if (driver != null) {
            driver.quit();
        }
    }


    @BeforeEach
    public void setUp() throws InterruptedException {
        basePage = new BasePage(driver);
        driver.get("https://www.paniodprogramowania.pl");
        Thread.sleep(2000);
        basePage.clickCookieAcceptButton();
    }
}
