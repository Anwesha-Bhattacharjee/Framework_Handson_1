package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.DataProviders;

public class FetchWebsiteTitleDDT extends TestBase {

	@Test(dataProvider = "dp1", dataProviderClass = DataProviders.class)
	public void fetchWebsiteDetailsAndMatch(String id, String url, String title) {
		driver.navigate().to(url);
		System.out.println(id + url + title);
		//Assert.assertEquals(driver.getTitle(), title);
		Assert.assertTrue(driver.getTitle().contains(title));
	}
}
