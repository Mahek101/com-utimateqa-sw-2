package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();// Find sign in link and click
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]")).getText();//Find actual text and get it with get method
        Assert.assertEquals("User is not on Lodin page", expectedText, actualText);// chech expected vs actual
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();// Find sign in link and click
        driver.findElement(By.id("user[email]")).sendKeys("megha123@gmail.com");//Find email field and enter email
        driver.findElement(By.id("user[password]")).sendKeys("12345");// Find password field and enter password
        driver.findElement(By.xpath("//button[@type='submit']")).click();// Find sign in link and click it
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();//Find actual text and get it
        Assert.assertEquals("Error message is not displayed", expectedMessage, actualMessage);// chech expected message vs actual message
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
