package com.qsp.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	
	public static void main(String[] args) {
		WebDriver driver = getmydriver();
		driver.get("file:///D:/QSP_EclipseWS/SeleniumPractice/html/PageLoadApp.html");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("btnContinue"))));
		
		driver.findElement(By.id("btnContinue")).click();
		System.out.println("Element found successfully");
	
	}

	private static WebDriver getmydriver() {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
	}
}
