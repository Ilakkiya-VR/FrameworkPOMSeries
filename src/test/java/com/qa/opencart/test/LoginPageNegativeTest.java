package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageNegativeTest {

	@Epic("EP-100: Design the Open Cart App Login Page")
	@Feature("F-101: design open cart login feature")
	@Story("US-51: develop login core features: title, url, user is able to login")

	public class LoginPageTest extends BaseTest {
		
		@Description("login with incorrect credential....")
		@Link("")
		@Owner("Ilakkiya")
		@Severity(SeverityLevel.CRITICAL)
		
		@DataProvider 
		public Object[][] provideInvalidCredential() {
			return new Object[][] {{"Aaru","test123"},
					{"march2024@open.com","arr123"},
					{"",""}
		};
	}

		@Test(dataProvider="provideInvalidCredential")
		public void loginWithIncorrectCredential(String invalidUser, String invalidPwd) {
		Assert.assertTrue(loginPage.doLoginiWthIncorrecCredential(invalidUser, invalidPwd));
		}
	}	
}
