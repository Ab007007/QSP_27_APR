package com.qsp.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
		return driver;
	}
}
