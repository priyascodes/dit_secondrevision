package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestHowLinkedTestWorks {

    WebDriver driver;
    String browser;
    String url;
    @BeforeTest
    public void loadConfigFile() {
        String path = System.getProperty("user.dir")+ "/src/test/java/resources/config.properties";
        System.out.println(path);
        Properties prop = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        browser = prop.getProperty("browser");
        url = prop.getProperty("url");

    }

    @BeforeClass
    public void setup(){
        System.out.println(browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(url);
        }
        else {
            System.out.println("invalid browser type or not supported");
            Assert.fail();

        }

    }

    @Test
    public void testLinkedLists() throws InterruptedException {
        WebElement sports = driver.findElement(By.linkText("Sport"));
        sports.click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
