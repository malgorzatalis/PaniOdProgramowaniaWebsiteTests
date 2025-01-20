package pl.paniodprogramowania.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.paniodprogramowania.pages.HomePage;


public class BaseTest {
    protected static WebDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
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
        homePage = new HomePage(driver);
        driver.get("https://www.paniodprogramowania.pl");
        Thread.sleep(2000);
        homePage.clickCookieAcceptButton();
    }
}
