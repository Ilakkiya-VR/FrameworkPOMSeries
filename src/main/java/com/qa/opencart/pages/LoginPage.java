package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private By locators: page objects
	private final By homemenu = By.xpath("//ul[@class='breadcrumb']//a");
	private final By headers = By.cssSelector("div.well h2");
	private final By subHeaders = By.xpath("//div[@class='well']//p");
	private final By returnCustLabels = By.cssSelector("div.form-group label");
	private final By email = By.id("input-email");
	private final By pwd = By.id("input-password");
	private final By loginbt = By.cssSelector("input[type= 'submit']");
	private final By forgotpwdlink = By.linkText("Forgotten Password");
	private final By NewCustcontinuebtn = By.linkText("Continue");
	private final By optionList = By.xpath("//div[@class='list-group']/a");
	private final By register=By.linkText("Register");

	// public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);

	}

	// public page method/action

	@Step("getPageTitle................")
	public String getPageTitle() {
		String title=eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, 5);
		System.out.println("Login Page Title: " + title);
		return title;
	}
	@Step("getPageURL................")
	public String getPageURL() {
		String url= eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, 5);
		System.out.println("Login Page Title: " + url);
		return url;
	}
@Step("ForgotPwdLinkExist...........")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotpwdlink);
		
	}
@Step("getting homeMenuCount...........")
	public int homeMenuCount() {

		List<WebElement> hmeMenu = eleUtil.getElements(homemenu);
		return hmeMenu.size();
	}

@Step("getting homeMenuDetails...........")

	public List<String> homeMenuDetails() {

		List<WebElement> hmeMenu = eleUtil.getElements(homemenu);
		List<String> hmeMenuDetails = new ArrayList<String>();
		for (WebElement e : hmeMenu) {
			String text = e.getText();
			hmeMenuDetails.add(text);
		}
		return hmeMenuDetails;
	}

@Step("getting subHeadersCount...........")
	public int subHeadersCount() {
		List<WebElement> subHeaderCount = eleUtil.getElements(subHeaders);
		return subHeaderCount.size();
	}
@Step("getting subHeadersDetails...........")
	public List<String> subHeadersDetails() {
		List<WebElement> subHeadersde = eleUtil.getElements(subHeaders);
		List<String> subHeaderDetails = new ArrayList<String>();
		for (WebElement e : subHeadersde) {
			String text = e.getText();
			subHeaderDetails.add(text);
		}
		return subHeaderDetails;
	}

@Step("getting returnCustLabelCount...........")
	public int returnCustLabelCount() {
		List<WebElement> CustLabelCount =eleUtil.getElements(returnCustLabels);
		return CustLabelCount.size();
	}

@Step("getting returnCustLabelDetail...........")
	public List<String> returnCustLabelDetail() {
		List<WebElement> CustLabelDetail = eleUtil.getElements(returnCustLabels);
		List<String> CustLabelDetails = new ArrayList<String>();
		for (WebElement e : CustLabelDetail) {
			String text = e.getText();
			CustLabelDetails.add(text);
		}
		return CustLabelDetails;
	}

@Step("getting optionListCount...........")
	public int optionListCount() {
		List<WebElement> optionListCount = eleUtil.getElements(optionList);
		return optionListCount.size();
	}

@Step("getting optionListlDetails...........")
	public List<String> optionListlDetails() {
		List<WebElement> optionListlDetail = eleUtil.getElements(optionList);		List<String> optionsDetails = new ArrayList<String>();
		for (WebElement e : optionListlDetail) {
			String text = e.getText();
			optionsDetails.add(text);
		}
		return optionsDetails;
	}

@Step("Login with username:{0}and password{1}...........")
	public AccountsPage doLogin(String appUserName,String appUserPwd)  {
		System.out.println("Application Credentials::"+appUserName+","+"**********");
		eleUtil.waitForElementVisible(email, 5).sendKeys(appUserName);
		eleUtil.doSendKeys(pwd, appUserPwd);
		eleUtil.doClick(loginbt);
		return new AccountsPage(driver);
	}
@Step("navigateToRegisterPage...........")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.clickElementWhenReady(register,5);
		return new RegisterPage(driver);
	}
}
