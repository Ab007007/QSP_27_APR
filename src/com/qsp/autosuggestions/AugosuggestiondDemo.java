package com.qsp.autosuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qsp.utils.ActitimeUtils;
import com.qsp.utils.DriverUtils;

public class AugosuggestiondDemo {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverUtils.getMyDriver();
		ActitimeUtils.launchApp("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Qspiders");
//		Thread.sleep(5000);	
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='erkvQe']"))));
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='sbct']"));
		
		System.out.println(suggestions.size());
		
		
		for (WebElement webElement : suggestions) 
		{
			System.out.println(webElement.getText());
			
		}
		
		
		
		
		
	
	
	
	}
}
