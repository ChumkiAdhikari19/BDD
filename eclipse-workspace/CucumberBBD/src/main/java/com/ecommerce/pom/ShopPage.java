package com.ecommerce.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

	
	public ShopPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='ui-slider-handle ui-state-default ui-corner-all'][2]")
	private WebElement rightSlider;
	
	@FindBy(xpath = "//span[@class='ui-slider-handle ui-state-default ui-corner-all'][1]")
	private WebElement leftSlider;
	
	@FindBy(xpath="//button[text()='Filter']")
	private WebElement filterButton;
	
	@FindBy(name="orderby")
	private WebElement orderByDropdowm;
	
	@FindBy(tagName = "h3")
	private List<WebElement> bookNames;
	
	@FindBy(xpath = "//h3/ancestor::a/following-sibling::a[text()='Add to basket']")
	private List<WebElement> addTobascketButton;

	public WebElement getRightSlider() {
		return rightSlider;
	}

	public WebElement getLeftSlider() {
		return leftSlider;
	}

	public WebElement getFilterButton() {
		return filterButton;
	}

	public WebElement getOrderByDropdowm() {
		return orderByDropdowm;
	}

	public List<WebElement> getBookNames() {
		return bookNames;
	}

	public List<WebElement> getAddTobascketButton() {
		return addTobascketButton;
	}

	
	
}