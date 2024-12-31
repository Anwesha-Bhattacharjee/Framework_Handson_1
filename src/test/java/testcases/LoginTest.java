package testcases;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends TestBase {
	@Test
    public void LogIn() throws InterruptedException {
    	String appUrl = properties.getProperty("loginTestURL");
    	driver.get(appUrl);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    	
    	System.out.println("inside@test"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSSSSSS")));
    	LoginPage lp = new LoginPage(driver);
    	lp.enterEmail(properties.getProperty("email"));
    	lp.enterPassword(properties.getProperty("pwd"));
    	lp.clickSignInBtn();
    	
    	Thread.sleep(2000);
        //assertTrue(true);
    }
}
