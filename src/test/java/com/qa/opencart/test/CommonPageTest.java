package com.qa.opencart.test;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class CommonPageTest extends BaseTest {
	@Test(priority =1)
	public void checkCommonFunctionsInLogin(){
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(commonPage.isLogoExist());
		softAssert.assertTrue(commonPage.isSearchExist());
		List<String> footerList=commonPage.getFooterList();
		softAssert.assertEquals(footerList.size(),AppConstants.EXPECTED_FOOTERLIST_COUNT);
		softAssert.assertAll();
	}
	
	@Test(priority =2)
	public void checkCommonFunctionsInAccountsPage(){
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(commonPage.isLogoExist());
		softAssert.assertTrue(commonPage.isSearchExist());
		List<String> footerList=commonPage.getFooterList();
		softAssert.assertEquals(footerList.size(),AppConstants.EXPECTED_FOOTERLIST_COUNT);
		softAssert.assertAll();
	}
	@Test(priority =3)
	public void checkCommonFunctionsInSearchResultPage(){
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	    accPage.searchPrdt("macbook");
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(commonPage.isSearchExist());
		softAssert.assertTrue(commonPage.isLogoExist());
		softAssert.assertTrue(commonPage.isSearchExist());
		List<String> footerList=commonPage.getFooterList();
		softAssert.assertEquals(footerList.size(),AppConstants.EXPECTED_FOOTERLIST_COUNT);
		softAssert.assertAll();
	}
}
