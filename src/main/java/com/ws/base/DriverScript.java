package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript 
{
	/*
	 * public driver reference which can be accessed throughout the project prop
	 * global variable is to access the properties class methods.
	 */
	public static WebDriver driver;
	Properties prop;

	/*
	 * This constructor is responsible for loading properties file.
	 */
	public DriverScript() 
	{
		try 
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) 
		{
			System.out.println("Unable to load the properties file");
		}
	}

	/*
	 * This method is used to launch the browser and apply all the wait setting and
	 * to navigate to the application.
	 */
	public void initApplication() 
	{
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.out.println("Browser in use is:" + browser);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.out.println("Browser in use is:" + browser);
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("edge browser")) 
		{
			System.out.println("Browser in use is:" + browser);
			driver = new EdgeDriver();
		} 
		else 
		{
			System.out.println("Unsupported browser!! please check properties file");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		getUrl();
	}
	/*
	 * This method is used to get the application url from properties file
	 */
	public void getUrl()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	public void quitDriver()
	{
		driver.quit();
	}

}












