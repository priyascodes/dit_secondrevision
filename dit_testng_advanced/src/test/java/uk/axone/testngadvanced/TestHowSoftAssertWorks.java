package uk.axone.testngadvanced;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestHowSoftAssertWorks {
    @Test
    public void testSoftAssert() {

        SoftAssert softassert = new SoftAssert();

        int expval = 123;
        int actval = 456;

        softassert.assertEquals(actval, expval, "Numbers are not matching");


        softassert.assertTrue(false, "condition is false");
        softassert.assertTrue(2 < 5, "condition is false");


        softassert.assertFalse(2 < 5, "condition is true");
        softassert.assertFalse(true, "conditon is true");

        softassert.assertAll();


    }
}
