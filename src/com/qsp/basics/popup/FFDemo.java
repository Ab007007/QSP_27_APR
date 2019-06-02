package com.qsp.basics.popup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class FFDemo {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = ActitimeUtils.getMyDriver("ff");
		ActitimeUtils.launchApp("https://www.seleniumhq.org/download/");
		ActitimeUtils.clickOnElement("xpath", "//a[text()='3.141.59']");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		

	}

}
