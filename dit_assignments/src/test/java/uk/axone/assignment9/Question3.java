package uk.axone.assignment9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Question3 {

    WebDriver driver;

    @BeforeTest
    public void setupWithImplicitWait(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.zoho.com/index1.html");
    }
    @Test
    public void testQuestion3() throws InterruptedException {

        WebElement signIn  = driver.findElement(By.linkText("Sign in"));
        signIn.click();
        WebElement logIn  = driver.findElement(By.id("login_id"));
        logIn.sendKeys("reachpriya@hotmail.com");
        WebElement loginReceived = driver.findElement(By.id("login_id"));
        System.out.println(loginReceived.getAttribute("value") + "value attr");







    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
