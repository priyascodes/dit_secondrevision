package uk.axone.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TestHowToTakeScreenshots {
    WebDriver driver;


    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.udemy.com/home/my-courses/learning/");
        driver.manage().window().maximize();
    }

    @Test
    public void testTakingScreenshots(){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(SystemUtils.getUserDir() + "/target/screenshots" +
                    "/udemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testAShot(){
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(SystemUtils.getUserDir() + "/target/screenshots" +
                    "/udemy_fullpage" +
                    ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
