package testcases;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import io.appium.java_client.android.AndroidDriver;

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
public void setup(String browser) throws MalformedURLException {
	ConfigReader configreader = new ConfigReader();
	properties = configreader.getProperties();
	//driver = new ChromeDriver();
//	DesiredCapabilities capabilities = new DesiredCapabilities();
	//driver = initializeLocalDriver(browser);
	
	if (properties.getProperty("executeOn").equalsIgnoreCase("local")) {
		driver = initializeLocalDriver(browser);
    } else if (properties.getProperty("executeOn").equalsIgnoreCase("grid")) {
    	driver = initializeGrid(browser);
    	
    } else if (properties.getProperty("executeOn").equalsIgnoreCase("saucelabs")){
        driver = initializeSauceLabs("Windows 7", browser);   
    } // add mobile once io.appium is resolved
	
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
    	case "MicrosoftEdge":
    		return new EdgeDriver();
    	default: 
    		System.out.println("Invalid browser provided: " + browser);
    		return null;
    	}
    }
    
    private WebDriver initializeGrid(String browser) throws MalformedURLException {
    	URL hubUrl = new URL(properties.getProperty("gridUrl"));
    	
    	System.out.println("init grid with " + browser);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);

        // Initialize the RemoteWebDriver with the Hub URL and capabilities
        return new RemoteWebDriver(hubUrl, capabilities);
    }
    
    private WebDriver initializeSauceLabs(String os, String browser) throws MalformedURLException {
    	ChromeOptions browserOptions = new ChromeOptions();;
//    	switch(browser) {
//    		case "MicrosoftEdge": 
//    			browserOptions = new InternetExplorerOptions();
//    			break;
//    		case "chrome": 
//    			browserOptions = new ChromeOptions();
//    			break;
//    		case "firefox":
//    			browserOptions = new FirefoxOptions();
//    			break;
//    	}
    	
    	browserOptions.setPlatformName(os);
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "selenium-build-ADMSE");
		sauceOptions.put("name", "Avishek-SAUCELABS"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")));
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		// start the session
		//URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		URL url = new URL("https://"+System.getenv("SAUCELABS_USERNAME")+":"+System.getenv("SAUCELABS_ACCESS_KEY")+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		return new RemoteWebDriver(url, browserOptions);
    }
    
    /*
    private WebDriver initializeAppiumDriver() {
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","samsung SM-S911B");
	    capabilities.setCapability("platformname", "Android");     
	    capabilities.setCapability("automationName","uiautomator2");
	    capabilities.setCapability("platformversion", "14");
	        
	    capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator");
	    capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	        
	    URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
	    return driver = new AndroidDriver(url, capabilities);
    }
    */

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
