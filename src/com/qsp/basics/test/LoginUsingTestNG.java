package com.qsp.basics.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.IterationRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qsp.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginUsingTestNG {
	
	WebDriver driver = null;
	

	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		
	}
	
	@Parameters("url")
	@BeforeMethod
	public void launchApp(String url)
	{
		driver.get(url);
		Assert.assertEquals(driver.getTitle(),"actiTIME - Login");
		
	}
	
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
	
	@Parameters({"username","password"})
	@Test
	public void validateLoginTest(String un,String pwd) throws InterruptedException
	{
		
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	
		
		
	}
	
	@Test
	public void validateTasksPageTest() throws InterruptedException
	{
		
		driver.findElement(By.id("username")).sendKeys("admin1");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	
		driver.findElement(By.xpath("//a[div[text()='TASKS']]")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Task List");
		
		
		
	}
	
	
	public void takeScreenShot() throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshots\\ss_" +  ConfigReader.getDateAndTime() + ".png"));
	}
	
	
	

}
