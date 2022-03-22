package com.ecommerce.baseutilis;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	
	/*
	 * handling dropdown
	 */
	
	public void selectDropdown(WebElement element, int index) {
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void selectDropdown(WebElement element, String VisibleText) {
		Select sel=new Select(element);
		sel.selectByVisibleText(VisibleText);;
	}
	
	/*
	 * 2. Handle frame
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToWindow(WebDriver driver, String partialPagetitle) {
		Set<String> windows=driver.getWindowHandles();
		for(String window: windows) {
			driver.switchTo().window(window);
			String title=driver.getTitle();
			if(title.contains(partialPagetitle)) {
				break;
			}
		}
	}
	
	public byte[] takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void hanldeSlider(WebDriver driver, WebElement element,int xOffset, int yOffset) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).moveByOffset(xOffset, yOffset).release().build().perform();
	}
	
	public void scroll(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();;
	}
	
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	

}