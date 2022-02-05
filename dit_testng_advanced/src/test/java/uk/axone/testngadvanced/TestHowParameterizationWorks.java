package uk.axone.testngadvanced;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestHowParameterizationWorks {

    @Parameters({"username","password","city","dob"})
    @Test
    public void testParameterisation(String aUsername, String apass, String aCity, String aDOB){

        System.out.println("username is " + aUsername
        + "Password is " + apass
        + "city is " + aCity
        + "dob is " + aDOB);
    }


}
