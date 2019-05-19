package com.qsp.waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qsp.utils.DriverUtils;

public class PrintTextUsingEW {

	
	public static void main(String[] args) {
		
		WebDriver driver = DriverUtils.getMyDriver();
		
		driver.get("file:///D:/QSP_EclipseWS/SeleniumPractice/html/tiimeout.html");

		driver.findElement(By.xpath("//button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement textOnScreen = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("demo"))));
		
			
		System.out.println("Message displayed " + textOnScreen.getText());
		String text2 = driver.findElement(By.id("demo2")).getText();
		System.out.println(text2);
		
		
		
		
		
		
	
	}
}
