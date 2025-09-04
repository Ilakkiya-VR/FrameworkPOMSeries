package com.qa.opencart.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	By prdInfoTabs = By.cssSelector("ul.nav-tabs a");
	By descTab = By.xpath("//ul[contains (@class,'nav-tabs')]//a[text()='Description']");
	By pdtDescDetails = By.cssSelector("div#tab-description");
	By reviewTab = By.xpath("//ul[contains (@class,'nav-tabs')]//a[text()='Reviews (0)']");
	By reviewInputName = By.cssSelector("input#input-name");
	By reviewInputYourView = By.cssSelector("textarea#input-review");
	By rating = By.xpath("//input[@name='rating']");
	By submitRating = By.cssSelector("div.pull-right button#button-review");
	By warning = By.cssSelector("div.alert");

	public String pdtInfohPageTitle() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle();
	}

	public boolean getPrdInfoTabs(String tab1, String tab2) {
		List<WebElement> pdtInfoTabs = eleUtil.waitForElementsPresence(prdInfoTabs, 10);
		boolean tab1Found = false;
		boolean tab2Found = false;
		for (WebElement e : pdtInfoTabs) {
			String text = e.getText();
			System.out.println("Tab Found::" + text);
			if (text.equalsIgnoreCase(tab1)) {
				System.out.println(tab1 + " is present");
				tab1Found = true;
			}
			if (text.equalsIgnoreCase(tab2)) {
				System.out.println(tab2 + " is present");
				tab2Found = true;
			}
		}
		if (tab1Found && tab2Found) {
			System.out.println(tab1 + " and " + tab2 + " are present");
			return true;
		}

		return false;
	}

	public boolean getPdtDescDetails(String des) {
		WebElement desc = eleUtil.getElement(descTab);
		desc.click();
		WebElement prdtDescDetails = eleUtil.getElement(pdtDescDetails);
		String describ = prdtDescDetails.getText();
		if (describ.contains(des)) {
			System.out.println(describ);
			return true;
		}
		return false;

	}

	public String checkReviewWarning(String custName, String custView, String value) {
		WebElement review = eleUtil.getElement(reviewTab);
		review.click();
		WebElement ipName = eleUtil.getElement(reviewInputName);
		ipName.clear();
		ipName.sendKeys(custName);
		WebElement view = eleUtil.getElement(reviewInputYourView);
		view.clear();
		view.sendKeys(custView);
		List<WebElement> rate = eleUtil.getElements(rating);
		for (WebElement e : rate) {
			String val = e.getAttribute("value");
			if (val.contains(value)) {
				e.click();
				break;
			}
		}
		WebElement continueBtn = eleUtil.getElement(submitRating);
		continueBtn.click();
		WebElement warnMsg = eleUtil.waitForElementVisible(warning,10);
		String msg = warnMsg.getText();
		System.out.println(msg);
		return msg;
	}
}
