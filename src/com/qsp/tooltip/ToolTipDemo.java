package com.qsp.tooltip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qsp.utils.ActitimeUtils;
import com.qsp.utils.DriverUtils;

public class ToolTipDemo 
{

	public static void main(String[] args) 
	{
		WebDriver driver = DriverUtils.getMyDriver();
		ActitimeUtils.launchApp("https://www.google.com/");
		
		WebElement googleImg = driver.findElement(By.xpath("//img[@style='padding-top:51px']"));
		WebElement appsIcon = driver.findElement(By.xpath("//a[@class='gb_x gb_Ub']"));
		System.out.println(googleImg.getAttribute("title"));
		System.out.println(appsIcon.getAttribute("title"));
	}
}
