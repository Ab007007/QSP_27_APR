package com.qsp.basics.popup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class Dummy {
 
	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver= ActitimeUtils.getMyDriver();
		driver.navigate().to("https://www.engprod-charter.net/");
		Thread.sleep(5000);
		
		String text = "Hello World";
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		System.out.println("End");
	}
}
