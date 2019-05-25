package com.qsp.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qsp.utils.ActitimeUtils;

public class DropDownValues {

	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/form");
		WebElement dropDown = driver.findElement(By.id("select-menu"));
		
		
		Select sel = new Select(dropDown);
		List<WebElement> options = sel.getOptions();
		
		for (WebElement webElement : options) {
			
			System.out.println(webElement.getText());
		}
		
		
		
		
		
		
	}
}
