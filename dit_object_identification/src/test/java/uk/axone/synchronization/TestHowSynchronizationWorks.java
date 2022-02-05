package uk.axone.synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHowSynchronizationWorks {


    WebDriver driver;

    @BeforeTest
    public void setupWithImplicitWait(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/jquery-download-progress-bar-demo.html");
    }
    @Test
    public void testExplictWait() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog > div.progress-label"))).getText().equals("Complete!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Close')]"))).click();


    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
