package uk.axone.seleniumadvanced;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SimpleLaunchBrowser {

    @Test
    public void testSimpleBrowser(){

        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        FirefoxDriver fd = new FirefoxDriver();


    }

}
