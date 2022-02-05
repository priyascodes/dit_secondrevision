package uk.axone.testngadvanced;


import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
/* Three ways to skip test
1. @Ignore
2. @Test(enabled = false)
3. throw new SkipException("message");
 */
public class TestHowToSkipTests {

    @Test
    public void doLogiIn() {
        System.out.println("log in test");
    }

    @Test(enabled = false)
    public void doLogOut() {
        System.out.println("log out test");
    }
    @Ignore
    @Test
    public void verifyHomepage() {
        System.out.println("homepage test");
    }
    @Test
    public void verifyLandingpage() {
        System.out.println("landing page test");
        //if (!dateIsAvailable){
        throw new SkipException("data is not available");

    }

}
