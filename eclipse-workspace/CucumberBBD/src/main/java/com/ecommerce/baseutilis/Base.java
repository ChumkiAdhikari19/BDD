package com.ecommerce.baseutilis;

import org.openqa.selenium.WebDriver;

import com.ecommerce.pom.AddToBasketPage;
import com.ecommerce.pom.ContactUsPage;
import com.ecommerce.pom.HomePage;
import com.ecommerce.pom.PageObjectManager;
import com.ecommerce.pom.ShopPage;

public class Base {
	
	public WebDriver driver;
	public FileUtility fUtil;
	public WebDriverUtility webUtility;
	public HomePage homePage;
	public ShopPage shopPage;
	public PageObjectManager pageObjManager;
	public AddToBasketPage addToBasket;
	public ExcelUtility excelUtility;
	public ContactUsPage contactusPage;


}
