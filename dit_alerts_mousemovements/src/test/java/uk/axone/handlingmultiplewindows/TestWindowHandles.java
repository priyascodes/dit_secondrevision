package uk.axone.handlingmultiplewindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestWindowHandles {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://mail.axone-tech.uk/useful-links");
    }

    @Test
    public void testwindowhandles(){
        WebElement mainWindowLink = driver.findElement(By.cssSelector("#newWin>h3"));
        mainWindowLink.click();
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Size of windows collections:  " + windows.size());

        Iterator<String> itr = windows.iterator();
        String aWindow = itr.next();
        driver.switchTo().window(aWindow);
        System.out.println("Title is : " + driver.getTitle());

        String anotherWindow = itr.next();
        driver.switchTo().window(anotherWindow);
        System.out.println("Title is : " + driver.getTitle());

        driver.close();
        driver.switchTo().window(aWindow);

        System.out.println("Title after closing popup is : " + driver.getTitle());


    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}
