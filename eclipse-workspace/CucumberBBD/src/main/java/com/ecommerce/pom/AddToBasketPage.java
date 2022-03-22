package com.ecommerce.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToBasketPage {
	public AddToBasketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Shop")
	private WebElement shopLink;
	
	@FindBy(xpath="(//a[text()='Add to basket'])[2]")
	private WebElement addToB;
	
	@FindBy(linkText="View Basket")
	private WebElement ViewBasket;
	
	@FindBy(partialLinkText="Functional Programming in JS")
	private WebElement productName;
	
	public WebElement getShopLink() {
		return shopLink;
	}

	public WebElement getAddToB() {
		return addToB;
	}

	public WebElement getViewBasket() {
		return ViewBasket;
	}

	public WebElement getProductName() {
		return productName;
	}
	
}
