package uk.axone.testngbasics;

import org.testng.annotations.Test;

public class TestHowToManageDependentTest {
    @Test(priority = 1)
    public void launchBrowser(){
        System.out.println("launch Browser");
    }

    @Test(dependsOnMethods = "launchBrowser")
    public void navigateToUrl(){
        System.out.println("Navigate to Url");
    }

    @Test(dependsOnMethods = "navigateToUrl")
    public void logIn(){
        System.out.println("log In");
    }
    @Test(dependsOnMethods = "logIn")
    public void shoppingCart(){
        System.out.println("shopping cart");
    }
    @Test(dependsOnMethods = "shoppingCart",priority = 0)
    public void checkout(){
        System.out.println("checkout");
    }





}
