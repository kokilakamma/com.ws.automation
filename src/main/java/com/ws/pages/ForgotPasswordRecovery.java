package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class ForgotPasswordRecovery extends DriverScript {
	
	//--- Page element identification
	@FindBy(xpath = "//h1[text()='Password recovery']") WebElement passwordRecoveryText;
	@FindBy(xpath = "//input[@id='Email']") WebElement passwordrecoveryemailTextField;
	@FindBy(xpath = "//span[@for='Email']") WebElement wrongEmailText;
	@FindBy(name = "send-email") WebElement recoverButton;
	@FindBy(xpath = "//div[@class = 'result']") WebElement emailInstructionSentMessage;
	
	//----Page initialization
	public ForgotPasswordRecovery()
	{
		PageFactory.initElements(driver, this);
	}
	
	//----Page Actions/Methods
	
	public boolean isPasswordRecoverDisplayed()
	{
		return passwordRecoveryText.isDisplayed();
	}
	public String getPasswordRecoveryText()
	{
		 return passwordRecoveryText.getText();
	}
	
	public void enterEmail(String email)
	{
		passwordrecoveryemailTextField.clear();
		passwordrecoveryemailTextField.sendKeys("email");
	}
	
	public void clickRecoverButton()
	{
		recoverButton.click();
	}
	 
	public String getWrongEmailMessage()
	{
		return wrongEmailText.getText();
	}
	public String getEmailSentMessage()
	{
		return emailInstructionSentMessage.getText();
	}
	public String recoveryPageTitle()
	{
		return driver.getTitle();
	}

}














