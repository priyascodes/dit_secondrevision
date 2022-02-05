package uk.axone.handlingmultiplewindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;
import java.util.concurrent.TimeUnit;

public class TestMouseMovements {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.americangolf.eu/");
    }

    @Test
    public void testMousemovements() throws InterruptedException {
        Thread.sleep(2000);


        String golfClubbyCss = "#header-navigation>div>ul>li:nth-child(4)>a";
        String golfClubbyXpath = "//a[contains(@href,'https://www.americangolf.eu/golf-clubs') and @class= " +
                "'a-level-1']";
        String golfClubbySimplerXpath = "//a[@class = 'a-level-1' and contains(text(), 'Golf Clubs')]";
        WebElement golfClubLink_CSS = driver.findElement(By.cssSelector(golfClubbyCss));
        WebElement golfClubLink_Xpath = driver.findElement(By.xpath(golfClubbyXpath));
        WebElement golfClubLink_Simple_XPath = driver.findElement(By.xpath(golfClubbySimplerXpath));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(golfClubLink_CSS));

        Actions actions = new Actions(driver);

        actions.moveToElement(golfClubLink_CSS);





    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}

