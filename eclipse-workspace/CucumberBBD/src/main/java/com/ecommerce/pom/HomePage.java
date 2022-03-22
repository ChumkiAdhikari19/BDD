package com.ecommerce.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Shop")
	private WebElement shopLink;
	
	@FindBy(linkText="My Account")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[@title='Start shopping']")
	private WebElement myCartLink;
	
	@FindBy(xpath = "//i[@class='icon-search']")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//input[@title='Search']")
	private WebElement searchTextfield;

	public WebElement getShopLink() {
		return shopLink;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}
	
	
	

}