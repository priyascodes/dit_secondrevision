package uk.axone.testngbasics;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("after Test");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after Class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after Method");
    }


    @Test
    public void myFirstTest(){
        System.out.println("logging in");
    }

    @Test
    public void mySecondTest(){
        System.out.println("shoppingcart test");
    } @Test
    public void myThirdTest(){
        System.out.println("logging out");
    }


}
