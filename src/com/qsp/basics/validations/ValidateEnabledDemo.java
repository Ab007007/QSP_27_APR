package com.qsp.basics.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qsp.utils.ActitimeUtils;

public class ValidateEnabledDemo {
	
	//
	
	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/enabled");
		
		System.out.println(driver.findElement(By.id("disabledInput")).isEnabled());
		System.out.println(driver.findElement(By.id("input")).isEnabled());
		
		WebElement textBox1 = driver.findElement(By.id("disabledInput")); //.sendKeys("Frist input");
		WebElement textBox2 = driver.findElement(By.id("input")); //.sendKeys("Second input");
		
		typeOnelement(textBox1, "DummyText1");
		typeOnelement(textBox2, "DummyText2");
		
		
		
	}

	
	public static void typeOnelement(WebElement ele,String texttoType)
	{
		if(ele.isEnabled())
		{
			ele.sendKeys(texttoType);
		}
		else
		{
			System.out.println("Element is disabled.... cant perfom operation");
		}
		
		
	}
}
