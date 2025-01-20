package pl.paniodprogramowania.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {
    @Test
    public void isDisplayedElement(){
        assertTrue(homePage.isDisplayed(), "Element powinien być wyświetlany");
    }
}