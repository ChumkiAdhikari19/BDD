package com.ecommerce.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	

	
	
	@FindBy(id="id_contact")
	private WebElement subjectheading;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="id_order")
	private WebElement orderRef;
	
	@FindBy(id="message")
	private WebElement messageText;
	
	@FindBy(id="submitMessage")
	private WebElement sendButton;
	 
	@FindBy(xpath="//p[@class=\"alert alert-success\"]")
	private WebElement successMessage;
	
	
	
	public WebElement getSubjectheading() {
		return subjectheading;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getOrderRef() {
		return orderRef;
	}

	public WebElement getMessageText() {
		return messageText;
	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}
	
	
}
