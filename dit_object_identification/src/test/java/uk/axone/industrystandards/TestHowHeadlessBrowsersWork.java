package uk.axone.industrystandards;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class TestHowHeadlessBrowsersWork {

    @Test
    public void testheadless(){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://uitest.automationtester.uk/");
        System.out.println("Title from Chromeoptions is: " + driver.getTitle());
        System.out.println("current url is " + driver.getCurrentUrl());
        driver.quit();

    }

    @Test
    public void testheadlessHUD(){
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
        driver.get("http://uitest.automationtester.uk/");
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("current url is " + driver.getCurrentUrl());
        driver.quit();

    }
}
