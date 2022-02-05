package uk.axone.testngadvanced;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestHowAssertWorks {

    @Test
    public void testAssertEquals() {

        int expval = 123;
        int actval = 456;

        Assert.assertEquals(actval, expval, "Numbers are not matching");
    }
    @Test
    public void testAssertTrue() {

        Assert.assertTrue(false, "condition is false");
        Assert.assertTrue(2 < 5, "condition is false");

    }

    @Test
            public void testAssertFalse(){
        Assert.assertFalse(2<5, "condition is true");
        Assert.assertFalse(true, "conditon is true");

    }
}
