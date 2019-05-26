package com.qsp.basics.switchto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class AlertsDemo {

	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.clickOnModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		
		
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("junkTExt");
		ActitimeUtils.waitTime(2000);
		driver.findElement(By.id("customerLightBox_cancelBtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("customerLightBox_cancelBtn")).click();
		driver.switchTo().alert().accept();

	}
}
