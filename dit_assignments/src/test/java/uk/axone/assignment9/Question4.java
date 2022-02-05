package uk.axone.assignment9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Question4 {

    WebDriver driver;

    @BeforeTest
    public void setupWithImplicitWait(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
    }
    @Test
    public void testQuestion4() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        WebElement allExamples = driver.findElement(By.cssSelector("ul[id='treemenu'] > li>a"));
        WebElement allExamples1 = driver.findElement(By.cssSelector("#treemenu > li > a"));


        WebElement inputForm = driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a"));
        inputForm.click();
        WebElement simpleDemoForm = driver.findElement((By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > " +
                "li:nth-child(1) > a")));
        simpleDemoForm.click();

        WebElement inputA = driver.findElement(By.cssSelector("#sum1"));
        inputA.sendKeys("20");
        WebElement inputB = driver.findElement(By.cssSelector("#sum2"));
        inputB.sendKeys("30");
        WebElement totalButton = driver.findElement(By.cssSelector("#gettotal > button"));
        totalButton.click();
        WebElement sum = driver.findElement(By.cssSelector("#displayvalue"));
        String sumTotal = sum.getText();

        int actResult  = Integer.parseInt(sumTotal);
        int expectedResult = 50;
        soft.assertEquals(actResult,expectedResult, "Sum not expected");
        soft.assertAll();


    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
