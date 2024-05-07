package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordRecoveryPage extends BaseTest{
	
	@Test(priority = 1)
	public void testForgotPassword() {
		logger=report.createTest("Testing password recovery page");
		
		homepage.clickLogin();
		logger.pass("Clicked on login link");
		
		
		boolean flag = loginpage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("Forgot password link displayed");
		
		loginpage.clickForgotPasswordLink();
		logger.pass("Clicked on forgot password link");
		
		boolean flag1 = forgotpasswordpage.isPasswordRecoverDisplayed();
		Assert.assertTrue(flag1);
		logger.pass("Password recovery text is displayed");
		
		String actual = forgotpasswordpage.getPasswordRecoveryText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("recovery"));
		logger.pass("Password recovery text is validated");
		
		String title = forgotpasswordpage.recoveryPageTitle();
		System.out.println("Title of recovery page is :" +title);
		boolean display = forgotpasswordpage.isPasswordRecoverDisplayed();
		Assert.assertTrue(display);
		forgotpasswordpage.clickRecoverButton();
	}	
	
	@Test(priority= 2)
	public void testInvalidEmail()
	{
		logger= report.createTest("Test invalid email message");
		
		homepage.clickLogin();
		logger.pass("Clicked on login link");
		
		boolean flag = loginpage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("Forgot password link displayed");
		
		loginpage.clickForgotPasswordLink();
		logger.pass("Clicked on forgot password link");
		
		boolean flag1 = forgotpasswordpage.isPasswordRecoverDisplayed();
		Assert.assertTrue(flag1);
		logger.pass("Password recovery text is displayed");
		
		forgotpasswordpage.enterEmail("abcd");
		logger.pass("Entered invalid email");
		
		forgotpasswordpage.clickRecoverButton();
		logger.pass("Clicked on recover me button");
		
		String invalidtext = forgotpasswordpage.getWrongEmailMessage();
		System.out.println(invalidtext);
		Assert.assertTrue(invalidtext.contains("Wrong"));
		logger.pass("Validated the invalid email text is displayed");
	}
	
	@Test(priority = 3)
	public void testValidEmail()
	{
		logger = report.createTest("Test  valid email sent message");
		homepage.clickLogin();
		logger.pass("Clicked on login link");

		boolean flag = loginpage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("Forgot password link displayed");

		loginpage.clickForgotPasswordLink();
		logger.pass("Clicked on forgot password link");

		boolean flag1 = forgotpasswordpage.isPasswordRecoverDisplayed();
		Assert.assertTrue(flag1);
		logger.pass("Password recovery text is displayed");

		forgotpasswordpage.enterEmail("testingweb1234@gmail.com");
		logger.pass("Valid recovery email was entered");
		
		String validtext = forgotpasswordpage.getEmailSentMessage();
		System.out.println(validtext);
		Assert.assertTrue(validtext.contains("Email with instructions"));
		logger.pass("Email with instructions message is displayed");

	}
}



















