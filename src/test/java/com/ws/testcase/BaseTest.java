package com.ws.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.base.DriverScript;
import com.ws.pages.ForgotPasswordRecovery;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.utils.Helper;

public class BaseTest extends DriverScript {

	ExtentTest logger;
	ExtentReports report;
	HomePage homepage;
	LoginPage loginpage;
	ForgotPasswordRecovery forgotpasswordpage;
	
	@BeforeSuite
	public void setUpReport()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./testreports/extentreports.html");
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	@BeforeMethod
	public void setUp() {
		initApplication();
		homepage = new HomePage();
		loginpage = new LoginPage();
		forgotpasswordpage = new ForgotPasswordRecovery();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test failed!",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		report.flush();
		driver.quit();
	}

}
