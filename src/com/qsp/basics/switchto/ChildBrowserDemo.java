package com.qsp.basics.switchto;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qsp.utils.ActitimeUtils;

public class ChildBrowserDemo extends ActitimeUtils
{
	
	public static void main(String[] args) {
		WebDriver driver =  getMyDriver();
		launchApp("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.findElement(By.linkText("Contact Us")).click();
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it  =  windowIds.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		
		List<WebElement> emailIDs = driver.findElements(By.xpath("//a"));
		
		for (WebElement mailID : emailIDs) {
			System.out.println(mailID.getText());
		}
		driver.close();
		driver.switchTo().window(parentID);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'More')]"))).perform();
		
		System.out.println("end");
	}

}










