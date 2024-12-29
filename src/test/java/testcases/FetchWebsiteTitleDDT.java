package testcases;

import org.testng.annotations.Test;

import utilities.DataProviders;

public class FetchWebsiteTitleDDT {

	@Test(dataProvider = "dp1", dataProviderClass = DataProviders.class)
	public void fetchWebsiteDetailsAndMatch(String id, String url, String title) {
		System.out.println(id + url + title);
	}
}
