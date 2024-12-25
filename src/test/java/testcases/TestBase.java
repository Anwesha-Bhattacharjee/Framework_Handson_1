package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ConfigReader;

public class TestBase {

public WebDriver driver;
Properties properties;

@BeforeClass
public void setup() {
	ConfigReader configreader = new ConfigReader();
	properties = configreader.getProperties();
	driver = new ChromeDriver();
}

@AfterClass
public void teardown() {
	driver.quit();
}


}
