package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By homePageTitle = By.xpath("//h1[text()='Learn Automation Courses']");
	
	public String getTitleOfHomePage() {
		return driver.findElement(homePageTitle).getText();
	}

}
