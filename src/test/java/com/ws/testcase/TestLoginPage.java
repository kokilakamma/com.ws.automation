package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {

	@Test(priority = 1)
	public void testLoginPageTitle() {

		homepage.clickLogin();
		String title = loginpage.getLoginTitle();
		System.out.println("Title of the page is:" + title);
		Assert.assertTrue(title.contains("Login"));
	}

	@Test(priority = 2)
	public void testLoginFunctionality() {
		homepage.clickLogin();
		loginpage.enterEmail("testingweb1234@gmail.com");
		loginpage.enterPassword("password@123");
		loginpage.clickLoginButton();
		boolean flag = homepage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		homepage.clickLogoutLink();
		loginpage.forgotPasswordLink();
		
	}
	@Test(priority = 3)
	public void testForgotPassword() {
		boolean flag = loginpage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		loginpage.forgotPasswordLink();
		String title = forgotpasswordpage.recoveryPageTitle();
		System.out.println("Title of recovery page is :" +title);
		boolean display = forgotpasswordpage.isRecoveryTextDisplayed();
		Assert.assertTrue(display);
		forgotpasswordpage.enterEmail();
		forgotpasswordpage.clickRecoverButton();
		
	}

}





