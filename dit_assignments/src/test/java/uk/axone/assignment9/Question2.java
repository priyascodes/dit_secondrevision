package uk.axone.assignment9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Question2 {


    WebDriver driver;

    @BeforeTest
    public void setupWithImplicitWait(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.bbc.co.uk/");
    }
    @Test
    public void testQuestion2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement bbcTopMenu = driver.findElement(By.cssSelector("#orb-nav-links"));


   List<WebElement> allLinksFromBbcTopMenu =
           bbcTopMenu.findElements(By.cssSelector("ul[class='ssrcss-vp47zn-GlobalNavigationLinkList-En e1b8fg8n0'] li a"));
        //   List<WebElement> allLinksFromBbcTopMenu =
     //           bbcTopMenu.findElements(By.cssSelector("#orb-nav-links > ul > li > a "));
        List<String> allHrefs = new ArrayList<>();
        for (WebElement link : allLinksFromBbcTopMenu) {
            allHrefs.add(link.getAttribute("href"));

        }
        for (String href : allHrefs) {

            System.out.println(href);
        }



    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
