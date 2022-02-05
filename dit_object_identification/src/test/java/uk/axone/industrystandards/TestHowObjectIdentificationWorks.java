package uk.axone.industrystandards;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHowObjectIdentificationWorks {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testObjectIdentification() throws InterruptedException {
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("Title for site is :  " + driver.getTitle());
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("My first search");
        System.out.println(driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getAttribute("alt"));


        // WebElement tShirts =driver.findElement(By.linkText("T-shirts"));
       // tShirts.click();
        Thread.sleep(2000);

    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
