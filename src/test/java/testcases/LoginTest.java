package testcases;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
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
    	try {
    		driver.findElement(By.className("errorMessage"));
    		System.out.println("username or pass is wrong");
    		Assert.assertEquals(false, true);
    	}
    	catch (Exception e) {
    		//e.printStackTrace();
    		//Assert.fail("username or pass is wrong");
    		System.out.println("username or pass is correct"+e.getMessage());
    		Assert.assertEquals(true, true);
    	}
    	HomePage hp = new HomePage(driver);
    	String actualTitle = hp.getTitleOfHomePage();
    	String expectedTitle = properties.getProperty("HomePageTitle");
    	SoftAssert ast = new SoftAssert();
    	ast.assertEquals(actualTitle, expectedTitle, "Login is done successfully");
    	
    	
    	Thread.sleep(2000);
        //assertTrue(true);
    }
}
