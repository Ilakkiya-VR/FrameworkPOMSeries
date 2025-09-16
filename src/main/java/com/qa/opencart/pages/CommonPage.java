package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class CommonPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
 private final By logo =By.cssSelector("img.img-responsive");
 private final By footer=By.cssSelector("footer li a");
 private final By search= By.name("search");
 

 public boolean isLogoExist() {
	return eleUtil.isElementDisplayed(logo);
	 
 }
 public boolean isSearchExist() {
	 return eleUtil.isElementDisplayed(search);
 }
 public List<String> getFooterList() {
	List<WebElement> footerList= eleUtil.getElements(footer);
	List<String> footerLists=new ArrayList<String>();
	for(WebElement e:footerList)
	{
	String text =	e.getText();
	footerLists.add(text);
	}
	return footerLists;
 }
}
