package uk.axone.testngbasics;

import org.testng.annotations.Test;

public class TestNgOrderOfExec {

    @Test
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

}
