package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By homePageTitle = By.xpath("//h1[text()='Learn Automation Courses']");
	By cartBtn = By.xpath("//button[text()='Cart']");
	By courseCards = By.xpath("//*[contains(@class, 'course-card')]");
	
	public String getTitleOfHomePage() {
		return driver.findElement(homePageTitle).getText();
	}
	
	public WebElement getCartButton() {
		return driver.findElement(cartBtn);
	}
	
	public List<WebElement> getCourseCards() {
		return driver.findElements(courseCards);
	}
	

}
