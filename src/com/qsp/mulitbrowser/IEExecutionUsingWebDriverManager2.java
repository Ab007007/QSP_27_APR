package com.qsp.mulitbrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEExecutionUsingWebDriverManager2 {

	public static void main(String[] args) {
		
		
//		WebDriverManager.iedriver().setup();
//		WebDriver driver = new InternetExplorerDriver();
//		
		
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().version("55.5").setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		
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
		
		driver.close();
	}
}
