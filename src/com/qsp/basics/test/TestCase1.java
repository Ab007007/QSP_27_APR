package com.qsp.basics.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qsp.utils.ConfigReader;

public class TestCase1 {

	WebDriver driver = null;

	@Test
	public void loginTest() throws InterruptedException, MalformedURLException {

		//"http://192.168.1.100:5555"
		String nodeIP = "http://192.168.1.149:5555";
		ChromeOptions options = new ChromeOptions();
		// FirefoxOptions options = new FirefoxOptions();
//	InternetExplorerOptions options =  new InternetExplorerOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// options.addArguments("disable-infobars");

		driver = new RemoteWebDriver(new URL(nodeIP + "/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");

		driver.findElement(By.id("username")).sendKeys("admin1");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");

	}

	@AfterMethod
	public void logoutApp(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				takeScreenShot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.findElement(By.id("logoutLink")).click();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");

	}

	public void takeScreenShot() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshots\\ss_" + ConfigReader.getDateAndTime() + ".png"));
	}

}
