package testcases;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class LaunchBrowser extends TestBase{

@Test
    public void validateLaunch() {
    	String appUrl = properties.getProperty("appURL");
    	driver.get(appUrl);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    	String actualTitle = driver.getTitle();
    	String expectedTitle = properties.getProperty("BrowserTitle");
    	SoftAssert sa = new SoftAssert();
    	sa.assertEquals(actualTitle, expectedTitle, "Strings are matching");
    	sa.assertAll();
    	
        //assertTrue(true);
    }
}
