package uk.axone.seleniumadvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestToLaunchBrowserDynamically {
    WebDriver driver;
    @Test
    public void testBrowserLaunchDynamically() throws InterruptedException {
        String browserType = "chrome";


        if (browserType.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        else if (browserType.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();

        }
        else if (browserType.equalsIgnoreCase("Edge")){
            System.out.println("Launching Edge");
        }
        else if (browserType.equalsIgnoreCase("Opera")){
            System.out.println("Launching OPera");
        }
        else{
            System.out.println("Invalid Browser type");
        }
        driver.get("http://uitest.automationtester.uk/");
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);
        driver.close();
    }
}
