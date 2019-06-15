package com.qsp.basics.js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class JavaScriptDemo {

	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/scroll");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0,500);");	
		
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.id("name")));
		
	}
}
