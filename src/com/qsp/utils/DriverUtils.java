package com.qsp.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

	public static WebDriver driver = null;
	
	/**
	 * getMyDriver returns a Chrome driver by defalut
	 * @author Aravind
	 * @return --> WebDriver
	 */
	public static WebDriver getMyDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public static WebDriver getMyDriver(String browserName)
	{
		driver = null;
		System.out.println("Creating a driver object for " + browserName);
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		
		default:
			System.out.println("Please contact Framework Developers to support more browsers..");
			break;
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
	public static void waitTime(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectCheckbox(WebElement checkBox) {
		if(checkBox.isSelected())
		{
			System.out.println("CheckBox is already Selected..!!! Not performing any operation");
		}
		else
		{
			System.out.println("Selecting checkbox");
			checkBox.click();
		}
	}

	
	
	public static WebElement getMyElement(String locator,String locatorValue)
	{
		System.out.println("finding element using " + locator + " and " + locatorValue);
		WebElement ele = null;
		
		switch (locator.toLowerCase()) {
		case "id":
				ele = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			ele = driver.findElement(By.name(locatorValue));
			break;
		case "classname":
			ele = driver.findElement(By.className(locatorValue));
			
			break;
		case "tagname":
			ele = driver.findElement(By.tagName(locatorValue));
			
			break;
		case "linktext":
			ele = driver.findElement(By.linkText(locatorValue));
			
			break;
		case "ptext":
			ele = driver.findElement(By.partialLinkText(locatorValue));
			
			break;
		case "css":
			ele = driver.findElement(By.cssSelector(locatorValue));
			
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(locatorValue));
			
			break;
		
		default:
			System.out.println("Please pass valid locator");
			break;
		}
		
		return ele;
		
	}
	
	
	
	
	public static void clickOnElement(String locator,String locatorValue)
	{
		System.out.println("clicking on  element using " + locator + " and " + locatorValue);
		getMyElement(locator, locatorValue).click();
	}
	
	public static void typeOnElement(String locator,String locatorValue,String textToType)
	{
		System.out.println("type on  element using " + locator + " and " + locatorValue + " and " + textToType);
		getMyElement(locator, locatorValue).sendKeys(textToType);
	}
	
	
	public static String getTextOnElement(String locator,String locatorValue)
	{
		System.out.println("Getting text on  element using " + locator + " and " + locatorValue);

		return getMyElement(locator, locatorValue).getText();
	}
}












