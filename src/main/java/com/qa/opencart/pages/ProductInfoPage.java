package com.qa.opencart.pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String,String> pdtData;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private final By prdInfoTabs = By.cssSelector("ul.nav-tabs a");
	private final By descTab = By.xpath("//ul[contains (@class,'nav-tabs')]//a[text()='Description']");
	private final By pdtDescDetails = By.cssSelector("div#tab-description");
	private final By reviewTab = By.xpath("//ul[contains (@class,'nav-tabs')]//a[text()='Reviews (0)']");
	private final By reviewInputName = By.cssSelector("input#input-name");
	private final By reviewInputYourView = By.cssSelector("textarea#input-review");
	private final By rating = By.xpath("//input[@name='rating']");
	private final By submitRating = By.cssSelector("div.pull-right button#button-review");
	private final By warning = By.cssSelector("div.alert");
	private final By pdtHeader=By.tagName("h1");
	private final By pdtImage=By.cssSelector("li.image-additional");
	private final By productMetadata = By.xpath("(//ul[@class=\"list-unstyled\"])[8]/li");
	private final By productprice = By.xpath("(//ul[@class=\"list-unstyled\"])[9]/li");
	private final By pdtQty=By.xpath("//div[@class='form-group']/label");
	private final By pdtQtyValue=By.xpath("//div[@class='form-group']/input[@id='input-quantity']");
	private final By addToCart= By.xpath("//div[@class='form-group']/button[@id='button-cart']");

	

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
	private String getProductHeader() {
		String headerVal=eleUtil.waitForElementVisible(pdtHeader, 5).getText();
		System.out.println("Product Name::"+headerVal);
		return headerVal;
	}
	private int getProductImg() {
		int pdtImgCount =eleUtil.waitForElementsVisible(pdtImage, 5).size();
		System.out.println("Pdt Image Count::"+pdtImgCount);
		return pdtImgCount;
	}

	
	private void getProductData() {
		List<WebElement> pdtDetails=eleUtil.waitForElementsVisible(productMetadata, 5);
		System.out.println("Pdt Data Count::"+pdtDetails.size());
		pdtData=new HashMap<String,String> ();
		for(WebElement e:pdtDetails) {
			String metaData=e.getText();
			String data[]=metaData.split(":");
			String key=data[0].trim();
			String val=data[1].trim();
			pdtData.put(key, val);
		}
	}
	
	private void getProductPrice() {
		List<WebElement> pdtPriceDetails=eleUtil.waitForElementsVisible(productprice, 5);
		System.out.println("Price Details Entry Count::"+pdtPriceDetails.size());
		String pdtPrice=pdtPriceDetails.get(0).getText();
		String exTax=pdtPriceDetails.get(1).getText().split(":")[1].trim();
		pdtData.put("ProductPrice", pdtPrice);
		pdtData.put("Ex Tax", exTax);
		
	}
	public Map<String, String> getProductDataDetails() {
		pdtData=new HashMap<String,String> ();
		pdtData.put("ProductHeader", getProductHeader());
		pdtData.put("Product Image Count::", String.valueOf(getProductImg()));
		getProductData();
		getProductPrice();
		getProductImg();
		System.out.println("============================Product details in full================================\n"+pdtData);
		return pdtData;
	}
	
}
