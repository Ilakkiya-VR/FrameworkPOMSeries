package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;



public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// constructor for WebDriver
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// locators

	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input-lastname");
	private final By email = By.name("email");
	private final By phoneno = By.xpath("//*[@id=\"input-telephone\"]");
	private final By pwd = By.cssSelector("#input-password");
	private final By confirmpwd = By.id("input-confirm");
	private final By clkagreTerm = By.name("agree");
	private final By regtrclkbtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
	private final By accCreateConfirm = By.tagName("h1");
	private final By Logout=By.linkText("Logout");
	private final By register=By.linkText("Register");

	public boolean doUserRegistration(String name, String lName, String emailID, String mobileNo, String password) {
		eleUtil.doSendKeys(firstName, name);
		eleUtil.doSendKeys(lastName, lName);
		eleUtil.doSendKeys(email, emailID);
		eleUtil.doSendKeys(phoneno, mobileNo);
		eleUtil.doSendKeys(pwd, password);
		eleUtil.doSendKeys(confirmpwd, password);
		eleUtil.doClick(clkagreTerm);
		eleUtil.doClick(regtrclkbtn);
		String confirmMsg = eleUtil.doElementGetText(accCreateConfirm);
		System.out.println("Account Confirmation Message:" + confirmMsg);
		if (confirmMsg.contains(AppConstants.EXPECTED_USER_REGISTER_CONFIRM_MSG)) {
			eleUtil.doClick(Logout);
			eleUtil.doClick(register);
			return true;
		} else {
			return false;
		}

	}
}
