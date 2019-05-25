package com.qsp.cal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qsp.utils.ActitimeUtils;

public class SelectDateDemo {

	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/form");
		
		String date = "22";
		
		driver.findElement(By.id("datepicker")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'datepicker-dropdown')]"))));
	
		driver.findElement(By.xpath("//td[@class='day' and text()='" + date + "']")).click();
	
	
	
	}
}
