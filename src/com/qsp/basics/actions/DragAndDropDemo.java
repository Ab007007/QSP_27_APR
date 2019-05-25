package com.qsp.basics.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qsp.utils.ActitimeUtils;

public class DragAndDropDemo {
	
	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		
		System.out.println(src.getText());
		System.out.println(dest.getText());
		
		Actions act  =  new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		act.sendKeys().perform();
		System.out.println(dest.getText());
	
		
	
	}

}
