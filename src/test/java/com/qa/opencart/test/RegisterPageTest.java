package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.CsvUtil;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void doRegister()
	{
		registerPage =loginPage.navigateToRegisterPage();
		
	}
	@DataProvider
	public Object[][] provideUserDetails() {
		return new Object[][] {{"Sindhu","Bala","8968900100","ohmSiva"},
			};
	}
	@DataProvider
	public Object[][] getRegistrationDetailsFromExcel() {
		return ExcelUtil.getTestDataFrmExcel("Register");
	}
	@DataProvider
	public Object[][] getRegistrationDetailsFromCsv() {
	 return CsvUtil.csvData("register");
	}
	
 @Test(dataProvider="getRegistrationDetailsFromCsv")
 public void doUserRegister(String name, String lname, String phoneNo, String pwd) {
	Assert.assertTrue(registerPage.doUserRegistration(name, lname, StringUtils.getRandomMailsID(), phoneNo,pwd));	 
 }
	/*
	 * @Test(invocationCount=10) 
	 * public void callsamemethod() {
	 * System.out.println("call same method n number of times is Invocation"); }
	 */
}
