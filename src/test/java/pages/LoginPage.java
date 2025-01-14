package pages;

import java.sql.Driver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//WebDriver driver;
	
//	public LoginPage(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSSSSSS")));
//		this.driver = driver;
//		
//	}
	
	
	//WebElement username = driver.findElement(By.id("email1"));
	By usernameField = By.id("email1");
	
	//WebElement password = driver.findElement(By.name("password1"));
	By passwordField = By.id("password1");
	
	//WebElement signIn =driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	By signInBtn = By.className("submit-btn");
	
	

	public void enterEmail(String data) {
		driver.findElement(usernameField).sendKeys(data);
	}
	
	public void enterPassword(String data) {
		driver.findElement(passwordField).sendKeys(data);
	}
	
	public void clickSignInBtn() {
		driver.findElement(signInBtn).click();
	}

}
