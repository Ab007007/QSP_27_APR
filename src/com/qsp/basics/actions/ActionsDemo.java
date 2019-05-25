package com.qsp.basics.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qsp.utils.ActitimeUtils;
import com.qsp.utils.DriverUtils;

public class ActionsDemo {

	
	public static void main(String[] args) {
		WebDriver driver =  ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://localhost/login.do");
		
		Actions act  = new Actions(driver);
		
		act.sendKeys("admin").perform();
		DriverUtils.waitTime(2000);
		act.sendKeys(Keys.TAB).perform();
		DriverUtils.waitTime(2000);
		act.sendKeys("manager").perform();
		DriverUtils.waitTime(2000);
		act.sendKeys(Keys.ENTER).perform();
		
	}
}
