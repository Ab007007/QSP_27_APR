package com.qsp.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ActitimeUtils extends DriverUtils {

	public static void logout()
	{
		clickOnElement("linktext", "Logout");
	}
	
	public static void createCustomer(String cn, String cd) {
		typeOnElement("id", "customerLightBox_nameField", cn);
		typeOnElement("id", "customerLightBox_descriptionField", cd);
		clickOnElement("id", "customerLightBox_commitBtn");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		System.out.println("Waiting for toast message to appear");
		wait.until(ExpectedConditions.visibilityOf(getMyElement("xpath", "//div[@class='toast']")));

		System.out.println("Waiting for the toast message to disappaer");
	
		wait.until(ExpectedConditions.invisibilityOf(getMyElement("xpath", "//div[@class='toast']")));
	
	}

	public static void launchApp(String url) {
		System.out.println("Launching the application " + url);
		driver.get(url);

	}

	/**
	 * function to login to application
	 * 
	 * @param un  - admin
	 * @param pwd - manager
	 * @author Aravind
	 */
	public static void login(String un, String pwd) {
		System.out.println("Logging in to the app  with " + un + " and " + pwd);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateTitle("actiTIME - Enter Time-Track");
	}

	public static void validateTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	public static void clickOnModule(String moduleName) {
		switch (moduleName.toUpperCase()) {
		case "TASKS":
			driver.findElement(By.xpath("//a[div[text()='TASKS']]")).click();
			break;
		case "USERS":
			driver.findElement(By.xpath("//a[div[text()='USERS']]")).click();
			break;
		case "REPORTS":
			driver.findElement(By.xpath("//a[div[text()='REPORTS']]")).click();
			break;
		case "TIME-TRACK":
			driver.findElement(By.xpath("//a[div[text()='TIME-TRACK']]")).click();
			break;

		default:
			System.out.println("please enter valid module name");
			break;
		}

	}

	public static void clickOnNewCustomerButton() {
		driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();

	}

}
