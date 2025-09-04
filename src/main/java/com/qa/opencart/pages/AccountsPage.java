package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private final By accHeaders = By.tagName("h2");
	private final By accHeadersDetails = By.cssSelector("div#content a");
	private final By accOptionsListDetails = By.cssSelector("div.list-group a");
	private final By search = By.cssSelector("input[name='search']");
	private final By searchBtn = By.cssSelector("i.fa-search");

	public String accPageTitle() {
		String accPageTitle = eleUtil.waitForTitleIs(AppConstants.ACC_PAGE_TITLE, 5);
		return accPageTitle;
	}

	public int accHeadersCount() {
		List<WebElement> accCount = eleUtil.getElements(accHeaders);
		return accCount.size();
	}

	public int accHeadersDetailsCount() {
		List<WebElement> accHeadersCount = eleUtil.getElements(accHeadersDetails);
		return accHeadersCount.size();
	}

	public int accOptionsListDetailsCount() {
		List<WebElement> accOptionsListDetailsCount = eleUtil.getElements(accOptionsListDetails);
		return accOptionsListDetailsCount.size();
	}

	public SearchResultPage searchPrdt(String searchPdtName) {
		WebElement searchPdt = eleUtil.waitForElementVisible(search, 10);
		searchPdt.clear();
		searchPdt.sendKeys(searchPdtName);
		eleUtil.doClick(searchBtn);
		return new SearchResultPage(driver);
	}

}
