package com.qsp.basics.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qsp.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	@AfterMethod
	public void logoutApp(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				takeScreenShot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.findElement(By.id("logoutLink")).click();
		Assert.assertEquals(driver.getTitle(),"actiTIME - Login");
		
	}
	

	public void takeScreenShot() throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshots\\ss_" +  ConfigReader.getDateAndTime() + ".png"));
	}
	
	WebDriver driver = null;
	@Test
	public void loginTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(),"actiTIME - Login");
	
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	
	
	
	}
	
}
