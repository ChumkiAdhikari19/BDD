package com.ecommerce.pom;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private static WebDriver driver;
	private static HomePage homePage;
	private static ShopPage shopPage;
	private static AddToBasketPage addToBasket;
	private static ContactUsPage contactuspage;
	
	
	
	public static HomePage initHomePage() {
		return (homePage==null)?homePage=new HomePage(driver):homePage;//if homePage==null, if it's null create a object or else directly return this homPage
	}
	
	public static ShopPage initShopPage() {
		return (shopPage==null)?shopPage=new ShopPage(driver):shopPage;
	}
	
	public static AddToBasketPage initaddToBasketpage() {
		return (addToBasket==null)?addToBasket=new AddToBasketPage(driver):addToBasket;
	}
	
	public static ContactUsPage initcontactuspage() {
		return (contactuspage==null)?contactuspage=new ContactUsPage(driver):contactuspage;
	}

}