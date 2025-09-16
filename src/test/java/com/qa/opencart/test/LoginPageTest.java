package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EP-100: Design the Open Cart App Login Page")
@Feature("F-101: design open cart login feature")
@Story("US-50: develop login core features: title, url, user is able to login")

public class LoginPageTest extends BaseTest {
	
	@Description("login page title test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.MINOR)

	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getPageTitle();
		 ChainTestListener.log("Login Page Title::"+ actualTitle);
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Description("login page URL test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getPageURL();
		 ChainTestListener.log("Login Page URL::"+actualURL);
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	@Description("forgot password link exist test....")
	@Owner("Naveen Automation Labs")
	@Severity(SeverityLevel.CRITICAL)

	@Test
	public void isForgotPwdExist() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("homeMenuCount test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void homeMenuCount() {
		int actualHmeMenuCount = loginPage.homeMenuCount();
		ChainTestListener.log("Login Page Menu Count::"+actualHmeMenuCount);
		Assert.assertEquals(actualHmeMenuCount, AppConstants.EXPECTED_HEADERS_COUNT);
	}
	
	@Description("homeMenuDtails test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void homeMenuDtails() {
		List<String> actualHomeMenuDtails = loginPage.homeMenuDetails();
		ChainTestListener.log("Login Page Menu Details::"+actualHomeMenuDtails);
		Assert.assertEquals(actualHomeMenuDtails, AppConstants.EXPECTED_HOMEMENU_HEADERS_DETAILS);

	}
	
	@Description("custLabelCount test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void custLabelCount() {
		int actualreturnCustLabelCount = loginPage.returnCustLabelCount();
		ChainTestListener.log("Return Cust Label Count::"+ actualreturnCustLabelCount);
		Assert.assertEquals(actualreturnCustLabelCount, AppConstants.EXPECTED_RETURNCUST_LABELS_COUNT);
	}
	
	@Description("custLabelDetails test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void custLabelDetails() {
		List<String> actualcustLabelDetails = loginPage.returnCustLabelDetail();
		ChainTestListener.log("Cust Label Details::"+ actualcustLabelDetails);
		Assert.assertEquals(actualcustLabelDetails, AppConstants.EXPECTED_RETURNCUST_LABELS_DETAILS);
	}
	
	
	@Description("subHeaderDetails test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void subHeadersCount() {
		int actualSubHeaderCount = loginPage.subHeadersCount();
		ChainTestListener.log("Sub Header Count::"+ actualSubHeaderCount);
		Assert.assertEquals(actualSubHeaderCount, AppConstants.EXPECTED_SUBHEADERS_COUNT);
	}
	
	@Description("subHeaderDetails test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void subHeaderDetails() {
		List<String> actualsubHeaderDetails = loginPage.subHeadersDetails();
		ChainTestListener.log("Sub Header Details"+actualsubHeaderDetails);
		Assert.assertEquals(actualsubHeaderDetails, AppConstants.EXPECTED_SUBHEADERS_DETAILS);
	}

	@Description("optionsListCount test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void optionsListCount() {
		int actualOptionsListCount = loginPage.optionListCount();
		ChainTestListener.log("Options List Count::"+actualOptionsListCount);
		Assert.assertEquals(actualOptionsListCount, AppConstants.EXPECTED_OPTIONSLIST_COUNT);
	}
	
	@Description("optionsListDetails test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.NORMAL)

	@Test
	public void optionsListDetails() {
		List<String> actualoptionsListDetails = loginPage.optionListlDetails();
		ChainTestListener.log("Option List Details::"+actualoptionsListDetails);
		Assert.assertEquals(actualoptionsListDetails, AppConstants.EXPECTED_OPTIONSLIST_DETAILS);
	}
	
	@Description("login test....")
	@Link("")
	@Owner("Ilakkiya")
	@Severity(SeverityLevel.BLOCKER)


	@Test(priority = Integer.MAX_VALUE)
	public void loginTest() {
		AccountsPage accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		ChainTestListener.log("Acc Page Title::"+accPage);
		Assert.assertEquals(accPage.accPageTitle(), "My Account");
	}

}
