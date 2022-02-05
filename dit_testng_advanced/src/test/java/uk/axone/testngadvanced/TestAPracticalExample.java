package uk.axone.testngadvanced;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAPracticalExample {
    @Parameters({"browser"})
    @Test
    public void testCrossBrowser(String aBrowser){
        System.out.println("Browser is " + aBrowser);
    }
}
