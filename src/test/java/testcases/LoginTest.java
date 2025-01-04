package testcases;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    		HomePage hp = new HomePage(driver);
    		WebElement cartBtn = hp.getCartButton();
    		System.out.println("Total courses offered " + hp.getCourseCards().size());
    	}
    	catch (Exception e) {
    		//e.printStackTrace();
    		System.out.println(driver.findElement(By.className("errorMessage")).getText());
    		Assert.assertEquals(false, true);
    		
    	}
    	
    	driver.quit();
    	
    }
}
