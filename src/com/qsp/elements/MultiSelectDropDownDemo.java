package com.qsp.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qsp.utils.ActitimeUtils;

public class MultiSelectDropDownDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("file:///D:/QSP_EclipseWS/SeleniumPractice/html/multiSelect.html");
		
		Select sel = new Select(driver.findElement(By.xpath("//select")));
		
		sel.selectByIndex(0);
		sel.selectByValue("saab");
		sel.selectByVisibleText("Audi");
		
		Thread.sleep(3000);
		
		sel.deselectByIndex(0);
		Thread.sleep(3000);
		sel.deselectByValue("saab");
		Thread.sleep(3000);
		sel.deselectByValue("audi");
		
		
		
		
		
	}
}
