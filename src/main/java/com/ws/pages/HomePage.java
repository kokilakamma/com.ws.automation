package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ws.base.DriverScript;

public class HomePage extends DriverScript {
	// ----------- Page Elements identification

	@FindBy(linkText = "Log in") WebElement LoginLink;
	@FindBy(linkText = "Log out")WebElement logoutLink;

	// ---------- page initialization

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// ----------- Page Actions/Methods

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void clickLogin() {
		LoginLink.click();
	}
	public boolean isLogoutLinkDisplayed() {
		return logoutLink.isDisplayed();
	}

	public void clickLogoutLink() {
		logoutLink.click();
	}
}
