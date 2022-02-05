package uk.axone.seleniumbasics;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHelloWorld {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");



       ChromeDriver driver = new ChromeDriver();

    }
}
