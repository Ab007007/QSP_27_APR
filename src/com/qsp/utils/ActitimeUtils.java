package com.qsp.utils;

import org.openqa.selenium.WebDriver;

public class ActitimeUtils extends DriverUtils
{

	public static void launchApp(String url)
	{
		System.out.println("Launching the application " + url);
		driver.get(url);
	
	}
}
