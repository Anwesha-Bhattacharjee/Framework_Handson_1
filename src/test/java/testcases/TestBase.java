package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class TestBase {

public WebDriver driver;
Properties properties;

@BeforeClass
@Parameters("browser")
public void setup(String browser) {
	ConfigReader configreader = new ConfigReader();
	properties = configreader.getProperties();
	//driver = new ChromeDriver();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	switch(browser.toLowerCase()) {
	case"chrome":
		driver = new ChromeDriver();
		break;
	case "firefox": 
		driver = new FirefoxDriver();
		break;
	case "edge":
		driver = new EdgeDriver();
		break;
	default: 
		System.out.println("Invalid browser provided: " + browser);
		return; 
	}	
}

@AfterClass
public void teardown() {
	driver.quit();
}


}
