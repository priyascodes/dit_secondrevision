package uk.axone.handlingmultiplewindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestHowToHandleAlerts {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/javascript-alert-box-demo.html");
    }

    @Test
    public void testAlerts() throws InterruptedException {
    Thread.sleep(2000);
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys("Hello World");
        Thread.sleep(5000);

        System.out.println("Visible text is :  " + alert.getText());
        Thread.sleep(5000);

        alert.accept();

        Thread.sleep(2000);



    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}

