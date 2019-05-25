package com.qsp.basics.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qsp.utils.DriverUtils.waitTime;
import com.qsp.utils.ActitimeUtils;


public class MouseMMInSelenium {
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement closeIcon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"))));
		closeIcon.click();
		
		
		WebElement electronicsTab = driver.findElement(By.xpath("//span[text()='Electronics']"));
		WebElement WomenTab = driver.findElement(By.xpath("//span[text()='Women']"));
		WebElement hFTab = driver.findElement(By.xpath("//span[text()='Home & Furniture']"));
		WebElement tvTab = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		Actions act  =  new Actions(driver);
		
		act.moveToElement(electronicsTab).perform();
		waitTime(2000);
		act.moveToElement(WomenTab).perform();
		waitTime(2000);
		act.moveToElement(hFTab).perform();
		waitTime(2000);
		act.moveToElement(tvTab).perform();
		waitTime(2000);
		
		
		
		
		
		
	}

}
