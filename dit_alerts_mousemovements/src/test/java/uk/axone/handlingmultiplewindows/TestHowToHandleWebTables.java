package uk.axone.handlingmultiplewindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHowToHandleWebTables {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/dynamic_web_table.html");
    }

    @Test
    public void testWebTables() throws InterruptedException {

       List<WebElement> listOfCountries = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        List<WebElement> listOfCheckboxes = driver.findElements(By.xpath("//table/tbody/tr/td[4]/input"));
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

        System.out.println("Size of list is :    " + listOfCountries.size());

        for (int i = 0; i< listOfCheckboxes.size(); i++) {
            if (listOfCountries.get(i).getText().equalsIgnoreCase("UK")){
                listOfCheckboxes.get(i).click();
                System.out.println(listOfNames.get(i).getText());
                Thread.sleep(2000);

            }

        }


    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}

