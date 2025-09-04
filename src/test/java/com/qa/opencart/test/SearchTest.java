package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchTest extends BaseTest {

	@BeforeClass

	public void searchSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void searchTest() {
		searchResultsPage = accPage.searchPrdt("macbook");
		String atualSearchTitle = searchResultsPage.getSearchPageTitle();
		Assert.assertEquals(atualSearchTitle, "Search - macbook");

	}

	@Test
	public void searchResultsCount() {
		searchResultsPage = accPage.searchPrdt("samsung");
		int actualSearchPageCount = searchResultsPage.getSearchResultsCount();
		Assert.assertEquals(actualSearchPageCount, 2);
	}

	@Test
	public void SearchedPdtNameandPrice() {
		searchResultsPage = accPage.searchPrdt("macbook");
		Boolean actualPdtNme = searchResultsPage.getSearchedPdtName("MacBook Air");
		Boolean atualPdtPrice = searchResultsPage.getSearchedPdtPrice("$1,202.00");
		Boolean atualPdtExTaxPrice = searchResultsPage.getSearchedPdtPrice("Ex Tax: $1,000.00");
		Assert.assertEquals(true, actualPdtNme);
		Assert.assertEquals(true, atualPdtPrice);
		Assert.assertEquals(true, atualPdtExTaxPrice);
	}

	@Test
	public void selectProduct() throws InterruptedException {
		searchResultsPage = accPage.searchPrdt("samsung");
		productInfoPage = searchResultsPage.selectProduct("Samsung SyncMaster 941BW");
		String atualPrdInfoPage = productInfoPage.pdtInfohPageTitle();
		Assert.assertEquals(atualPrdInfoPage, "Samsung SyncMaster 941BW");

	}
}
