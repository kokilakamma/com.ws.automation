package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class ForgotPasswordRecovery extends DriverScript {
	
	//--- Page element identification
	@FindBy(xpath = "//h1[normalize-space()='Password recovery']") WebElement passwordRecoveryText;
	@FindBy(xpath = "//input[@id='Email']") WebElement emailTextField;
	@FindBy(xpath = "//span[@for='Email']") WebElement wrongEmailText;
	@FindBy(name = "send-email") WebElement recoverButton;
	
	//----Page initialization
	public ForgotPasswordRecovery()
	{
		PageFactory.initElements(driver, this);
	}
	
	//----Page Actions/Methods
	
	public boolean isRecoveryTextDisplayed()
	{
		 return passwordRecoveryText.isDisplayed();
	}
	
	public void enterEmail()
	{
		emailTextField.sendKeys("testingweb1234@gmail.com");
	}
	
	public void clickRecoverButton()
	{
		recoverButton.click();
	}
	 
	public String recoveryPageTitle()
	{
		return driver.getTitle();
	}

}














