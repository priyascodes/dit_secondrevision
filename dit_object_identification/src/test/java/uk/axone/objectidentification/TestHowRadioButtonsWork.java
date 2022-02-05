package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHowRadioButtonsWork {


    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-radiobutton-demo.html");
    }
    @Test
    public void testRadioButton() throws InterruptedException {
        List<WebElement> radios = driver.findElements(By.name("optradio"));
        System.out.println(radios.get(1).getAttribute("value"));
        radios.get(0).click();
        for (WebElement radio : radios) {
            System.out.println(radio.getAttribute("value") + " is displayed");

        }
        System.out.println(radios.get(0).isSelected());
        Assert.assertTrue(radios.get(0).isSelected());
        Thread.sleep(2000);

    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
