package com.qsp.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium 
{

	public static void main(String[] args) {
		
		System.out.println("Welcome to Selenium Automation");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost/login.do");
		
		/*
		 * WebElement usernameTextBox = driver.findElement(By.id("username"));
		 * 
		 * usernameTextBox.sendKeys("admin");
		 */
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.close();
	}
}
