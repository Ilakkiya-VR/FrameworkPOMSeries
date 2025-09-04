package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.SearchResultPage;

public class AccPageTest extends BaseTest {

	@BeforeClass

	public void accPageSetup() throws InterruptedException {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void accPageTitle() {
		String actualTitle = accPage.accPageTitle();
		Assert.assertEquals(actualTitle, "My Account");
	}

	@Test

	public void accHeadersCount() {
		int actualHeaderCount = accPage.accHeadersCount();
		Assert.assertEquals(actualHeaderCount, 4);
	}

	@Test

	public void accHeadersDetailsCount() {
		int actualHeadersDetailsCount = accPage.accHeadersDetailsCount();
		Assert.assertEquals(actualHeadersDetailsCount, 12);
	}

	@Test

	public void accOptionsListDetailsCount() {
		int actualaccOptionsListDetailsCount = accPage.accOptionsListDetailsCount();
		Assert.assertEquals(actualaccOptionsListDetailsCount, 13);
	}

	@Test

	public void searchPrdt() {
		SearchResultPage searchResultsPage = accPage.searchPrdt("macbook");
		Assert.assertEquals(searchResultsPage.getSearchPageTitle(), "Search - macbook");

	}

}
