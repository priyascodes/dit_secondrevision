package uk.axone.seleniumadvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestToLaunchBrowserDynamically {
    WebDriver driver;
    String browserType;
    String appUrl;
    @Test
    public void testBrowserLaunchDynamically() throws InterruptedException {

        String path = System.getProperty("user.dir")+"/src/test/resources/input_config.properties";
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            prop.load(fis);
            browserType = prop.getProperty("browser");
            appUrl = prop.getProperty("applicationUrl");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





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
        driver.get(appUrl);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);
        driver.close();
    }
}
