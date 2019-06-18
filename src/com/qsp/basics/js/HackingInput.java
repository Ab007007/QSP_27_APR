package com.qsp.basics.js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class HackingInput {

	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/enabled");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		js.executeScript("document.getElementById('disabledInput').value='JUNKTEXT';");
		js.executeScript("arguments[0].value='JUNKTEXT111';",
				driver.findElement(By.id("disabledInput")));
		
	}
}
