package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtil eleUtil;


	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}


	private final By searchResults = By.cssSelector("div.caption");
	private final By searchedPdtName = By.cssSelector("div.caption a");
	private final By searchedPdtPrice = By.cssSelector("div.caption p.price");
	
	public String getSearchPageTitle() {
	   return driver.getTitle();
	}

	public int getSearchResultsCount() {
		
		List<WebElement> searchCount= eleUtil.waitForElementsPresence(searchResults, 5);
		return searchCount.size();
	}

	public boolean getSearchedPdtName(String pdtName) {
		List<WebElement> pdtNme = eleUtil.getElements(searchedPdtName);
		for(WebElement e:pdtNme) {
			String text=e.getText();
			System.out.println(text);
			if(text.contains(pdtName)) {
				return true;
			}
		}
		return false;
	
	}

	public boolean getSearchedPdtPrice(String pdtPrice) {
		List<WebElement> priceDetails = eleUtil.getElements(searchedPdtPrice);
		for(WebElement e:priceDetails) {
			String text=e.getText();
			System.out.println(text);
			if(text.contains(pdtPrice)) {
				return true;
			}
		}
		return false;
	
	}

	public ProductInfoPage selectProduct(String pdtNme) {
		System.out.println("Selected Product Name:: "+pdtNme);
		eleUtil.doClick(By.linkText(pdtNme));
		return new ProductInfoPage(driver);
		
	}
}
