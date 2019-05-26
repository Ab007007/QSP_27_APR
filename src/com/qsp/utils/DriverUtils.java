package com.qsp.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
