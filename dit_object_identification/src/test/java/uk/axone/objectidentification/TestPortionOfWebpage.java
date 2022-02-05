package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestPortionOfWebpage {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shopping.rediff.com/?sc_cid=inhome_icon/");
    }
    @Test
    public void testPortionOfWebpage() throws InterruptedException {
        WebElement bestDealsParent = driver.findElement(By.id("div_bdeal_scroller"));
        List<WebElement> listOfDeals = bestDealsParent.findElements(By.xpath("//div[@id='div_bdeal_scroller']/div/div" +
                "/a"));
        //List<WebElement> listOfDeals2 = bestDealsParent.findElements(By.tagName("a"));
        System.out.println(listOfDeals.size());
        //System.out.println(listOfDeals2.size());

        for (WebElement deal : listOfDeals) {
            System.out.println(deal.getAttribute("href"));
            System.out.println(deal.getText());

        }


        //div[@id='div_bdeal_scroller']/div/div/a


        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
