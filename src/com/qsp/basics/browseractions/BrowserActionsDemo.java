package com.qsp.basics.browseractions;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class BrowserActionsDemo {

	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://localhost/login.do");
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.google.com");
		driver.manage().window().fullscreen();
		String windowID = driver.getWindowHandle();
		System.out.println(windowID);
				
	}
}
