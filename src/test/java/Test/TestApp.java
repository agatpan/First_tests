package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


public class TestApp {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();

    }


    @Test
    public void checkedGooglePage(){
        driver.get("http://www.google.pl/");
        WebElement buttonByName = driver.findElement(By.name("btnK"));

        assertTrue("Button is not displayed", buttonByName.isDisplayed());

    }

    @Test
    public void checkedGooglePage1(){
        driver.get("http://www.google.pl/");
        WebElement searchFieldById = driver.findElement(By.id("sfdiv"));

        assertTrue("Search Field is not displayed", searchFieldById.isDisplayed() );
    }

    @After
    public void tearDown() {driver.close(); }
}