package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void ProductInfoPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] providePdtData() {
		return new Object[][] { { "samsung", "Samsung SyncMaster 941BW" }, { "macbook", "MacBook Pro" },
				{ "iPhone", "iPhone" }, { "canon", "Canon EOS 5D" } };
	}

	@Test(dataProvider = "providePdtData")
	public void prdInfoPageTabs(String searchPdt, String pdtToSelect) {
		searchResultsPage = accPage.searchPrdt(searchPdt);
		productInfoPage = searchResultsPage.selectProduct(pdtToSelect);
		Boolean actualInfoTabs = productInfoPage.getPrdInfoTabs("Description", "Reviews (0)");
		Assert.assertTrue(actualInfoTabs);
	}

	@DataProvider
	public Object[][] providePdtDsc() {
		return new Object[][] {
				{ "samsung", "Samsung SyncMaster 941BW", AppConstants.EXPECTED_SAMSUNG941_DESC_DETAILS },
				{ "iPhone", "iPhone", AppConstants.EXPECTED_IPHONE_DESC_DETAILS }, };
	}

	@Test(dataProvider = "providePdtDsc")
	public void descDetails(String searchPdt, String pdtToSelect, String desc) {
		searchResultsPage = accPage.searchPrdt(searchPdt);
		productInfoPage = searchResultsPage.selectProduct(pdtToSelect);
		boolean atualDescDetail = productInfoPage.getPdtDescDetails(desc);
		Assert.assertTrue(atualDescDetail);
	}

	@Test(dataProvider = "providePdtData")
	public void checkReview(String searchPdt, String pdtToSelect) {
		searchResultsPage = accPage.searchPrdt(searchPdt);
		productInfoPage = searchResultsPage.selectProduct(pdtToSelect);
		String actualWarningMsg = productInfoPage.checkReviewWarning("ohm", "good", "5");
		Assert.assertEquals(actualWarningMsg, AppConstants.EXPECTED_WARNING_ERROR_REVIEW);
	}
	
	@Test
	public void getProductFullDetails() {
		searchResultsPage = accPage.searchPrdt("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
	Map<String,String>prdtDetails=	productInfoPage.getProductDataDetails();
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(prdtDetails.get("Brand"), "Apple");
	softAssert.assertEquals(prdtDetails.get("Availability"), "Out Of Stock");
	softAssert.assertEquals(prdtDetails.get("Ex Tax"), "$2,000.00");
	softAssert.assertEquals(prdtDetails.get("Product Code"), "Product 18");
	softAssert.assertEquals(prdtDetails.get("ProductPrice"), "$2,000.00");
	softAssert.assertEquals(prdtDetails.get("Reward Points"), "800");
	softAssert.assertAll();
	}
		
}
