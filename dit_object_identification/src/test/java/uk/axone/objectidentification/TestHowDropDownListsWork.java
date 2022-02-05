package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHowDropDownListsWork {


    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-select-dropdown-demo.html");
    }
    @Test
    public void testDropDownList() throws InterruptedException {
      WebElement dropdownList =  driver.findElement(By.id("select-demo"));
        List<WebElement> list = dropdownList.findElements(By.xpath("//select[@id = 'select-demo']/option"));
        System.out.println(list.size() + "size");

        System.out.println(list.get(0).getText()+ "Index 0");
        for (WebElement item : list) {
            System.out.println(item.getAttribute("value"));

        }

        Select select = new Select(dropdownList);
        List<WebElement> selectList = select.getOptions();
        for (WebElement selectItem : selectList) {
            System.out.println(selectItem.getAttribute("value"));

        }
        select.selectByValue("Tuesday");
        select.selectByIndex(5);
        Thread.sleep(2000);


    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
