package com.qsp.basics.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qsp.utils.ActitimeUtils;

public class ValidationsDemo {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/form");
		Thread.sleep(5000);
		/*
		driver.findElement(By.id("checkbox-1")).isDisplayed(); //boolean
		driver.findElement(By.id("checkbox-1")).isSelected(); //boolean
		driver.findElement(By.id("checkbox-1")).isEnabled(); //boolean
		driver.findElement(By.id("checkbox-1")).getText(); //String
		driver.findElement(By.id("checkbox-1")).getAttribute("");//String
		driver.getTitle();//String
		
		*/
		WebElement checkBox = driver.findElement(By.id("checkbox-1"));
		ActitimeUtils.selectCheckbox(checkBox);
	}


}
