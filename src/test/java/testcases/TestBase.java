package testcases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class TestBase {

public WebDriver driver;
Properties properties;
public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

@BeforeClass
@Parameters("browser")
public void setup(String browser) {
	ConfigReader configreader = new ConfigReader();
	properties = configreader.getProperties();
	//driver = new ChromeDriver();
//	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = initializeLocalDriver(browser);
	
	 if (driver != null) {
         setDriver(driver); // Set WebDriver in ThreadLocal
         driver = getDriver();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
         System.out.println("WebDriver initialized for: " + browser);
     } else {
    	 System.out.println("Failed to initialize WebDriver for browser: " + browser);
     }
	}	

public static void setDriver(WebDriver driver) {
    tdriver.set(driver);
}

// Get WebDriver instance from ThreadLocal
public static WebDriver getDriver() {
    return tdriver.get();
}
	
	
    // Initialize WebDriver for local execution
    private WebDriver initializeLocalDriver(String browser) {
    	switch(browser.toLowerCase()) {
    	case"chrome":
    		return new ChromeDriver();
    	case "firefox": 
    		return new FirefoxDriver();
    	case "edge":
    		return new EdgeDriver();
    	default: 
    		System.out.println("Invalid browser provided: " + browser);
    		return null;
    }
}

@AfterClass
public void teardown() {
	WebDriver driver = getDriver();
    if (driver != null) {
        driver.quit();
        System.out.println(driver);
        tdriver.remove(); // Remove WebDriver from ThreadLocal
        System.out.print(" WebDriver quit and removed from ThreadLocal.");
    }
}


}
