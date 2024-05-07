package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class LoginPage extends DriverScript {
	// --------------- Page Elements identification
	@FindBy(xpath = "//input[@id='Email']") WebElement EmailTextField;
	@FindBy(xpath = "//input[@id='Password']") WebElement PasswordTextField;
	@FindBy(xpath = "//input[@value='Log in']") WebElement LoginButton;
	@FindBy(linkText = "Forgot password?") WebElement ForgotPasswordLink;

	// --------------- Page initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// -------------- Page Actions/Methods
	public String getLoginTitle() {
		return driver.getTitle();
	}

	public void enterEmail(String email) {
		EmailTextField.sendKeys(email);
	}

	public void enterPassword(String password) {
		PasswordTextField.sendKeys(password);
	}

	public void clickLoginButton() {
		LoginButton.click();
	}

	public void clickForgotPasswordLink() {
		 ForgotPasswordLink.click();
			
	}
	public String getForgotPasswordTitle()
	{
		return driver.getTitle();
	}
	public boolean isForgotPasswordLinkDisplayed() {
		return ForgotPasswordLink.isDisplayed();
	}

}
