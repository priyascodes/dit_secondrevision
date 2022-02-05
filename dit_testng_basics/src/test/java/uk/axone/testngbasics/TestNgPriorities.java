package uk.axone.testngbasics;

import org.testng.annotations.Test;

public class TestNgPriorities {

    @Test(priority = 2)
    public void loginTest(){
        System.out.println("log in");
    }

    @Test
    public void shoppingcart(){
        System.out.println("shopping cart");
    }

    @Test
    public void logout(){
        System.out.println("log out");
    }
    @Test(priority = 1)
    public void logout2(){
        System.out.println("log out2");
    }

}
