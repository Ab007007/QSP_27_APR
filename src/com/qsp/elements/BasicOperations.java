package com.qsp.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qsp.utils.ActitimeUtils;
import com.qsp.utils.DriverUtils;

public class BasicOperations {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/form");
		
		driver.findElement(By.id("first-name")).sendKeys("Aravinda");
		driver.findElement(By.id("last-name")).sendKeys("HB");
		driver.findElement(By.id("job-title")).sendKeys("Trainer");
		driver.findElement(By.id("radio-button-2")).click();
		driver.findElement(By.id("checkbox-1")).click();
		
		
		WebElement dropDown = driver.findElement(By.id("select-menu"));
		
		Select sel = new Select(dropDown);
		
		sel.selectByIndex(3);
		
		Thread.sleep(3000);
		
		sel.selectByValue("4");
		
		Thread.sleep(3000);
		
		sel.selectByVisibleText("0-1");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
