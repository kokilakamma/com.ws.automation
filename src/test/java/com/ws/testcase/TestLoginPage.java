package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {

	@Test(priority = 1)
	public void testLoginPageTitle() {
		logger=report.createTest("Test Login Page:");
		
		homepage.clickLogin();
		logger.pass("Clicked on login link");
		
		String title = loginpage.getLoginTitle();
		logger.pass("get the home page title");
		System.out.println("Title of the page is:" + title);
		Assert.assertTrue(title.contains("Login"));
		logger.pass("Login page verification successful");
	}

	@Test(priority = 2)
	public void testLoginFunctionality() {
		logger= report.createTest("Testing login functionality");
		
		homepage.clickLogin();
		logger.pass("Clicked on login link");
		
		loginpage.enterEmail("testingweb1234@gmail.com");
		logger.pass("Entered Email");
		
		loginpage.enterPassword("password@123");
		logger.pass("Entered password");
		
		loginpage.clickLoginButton();
		logger.pass("Clicked on login button");
		
		boolean flag = homepage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("Verified for logout link");
		homepage.clickLogoutLink();
		logger.pass("Login successful");
		
//		loginpage.clickForgotPasswordLink();
//		logger.pass("Forgot password link is displayed");
//		
		
	}
	
}







