package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert. *;

public class DemoquaTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void registrationTest(){
        driver.get("http://demoqa.com/registration/");
        driver.findElement(By.id("name_3_firstname")).sendKeys("Agata");
        driver.findElement(By.xpath("//input[@id='name_3_lastname']")).sendKeys("Pan");
        driver.findElement(By.xpath("//input[@value='single']")).click();
        driver.findElement(By.xpath("//input[@value='reading']")).click();
        driver.findElement(By.xpath("//option[@value='Poland']")).click();
        Select dropMonthOfBirth = new Select (driver.findElement(By.id("mm_date_8")));
        Select dropDayOfBirth = new Select (driver.findElement(By.id("dd_date_8")));
        Select dropYearOfBirth = new Select (driver.findElement(By.id("yy_date_8")));
        dropMonthOfBirth.selectByVisibleText("7");
        dropDayOfBirth.selectByValue("1");
        dropYearOfBirth.selectByValue("1983");
        driver.findElement(By.xpath("//input[@id='phone_9']")).sendKeys("+48600123456");
        driver.findElement(By.id("username")).sendKeys("panagat");
        driver.findElement(By.id("email_1")).sendKeys("pa.agatka@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Hi, blabla bla");
        driver.findElement(By.xpath("//input[@id='password_2']")).sendKeys("987_agat");
        driver.findElement(By.xpath("//input[@id='confirm_password_password_2']")).sendKeys("987_agat");
        driver.findElement(By.id("piereg_passwordStrength")).click();

    }

    @Test
    public void checkElementMoveToGrayContener(){
        driver.get("http://demoqa.com/droppable/");
        WebElement elementBefore = driver.findElement(By.xpath("//div[@id='droppableview']"));
        WebElement elementAfter = driver.findElement(By.id("draggableview"));

        Actions moveElement = new Actions(driver);
        moveElement.dragAndDrop(elementAfter, elementBefore).build().perform();


        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.textToBePresentInElement(elementBefore, "Dropped!"));

        assertTrue("Element has been moved", elementBefore.getAttribute("class").contains("ui-state-highlight"));

    }

    @Test
    public void checkSelectData(){
        driver.get("http://demoqa.com/datepicker/");
        WebElement element1 = driver.findElement(By.xpath("//input[@id='datepicker1']"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//a[text()='15']"));
        element2.click();



        assertEquals("Date 15.02.2018", element1.getAttribute("value"),  "February 15, 2018");
    }

    @Test
    public void checkMenuContainsElements(){
        driver.get("http://demoqa.com/menu/");

        List<WebElement> listOfDocuments = (List<WebElement>) driver.findElement(By.xpath("//li[@class='ui-corner-left']"));




        WebElement aboutElement = driver.findElement(By.xpath("//a[text()='15']"));
        WebElement contactElement = driver.findElement(By.xpath("//a[text()='15']"));
        WebElement faqElement = driver.findElement(By.xpath("//a[text()='15']"));
        WebElement newsElement = driver.findElement(By.xpath("//a[text()='15']"));
    }




    @After
    public void tearDown(){driver.close();}

}
