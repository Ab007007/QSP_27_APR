package com.qsp.basics.popup;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class HiddenDivisionPopUpDemo  extends ActitimeUtils
{

	
	public static void main(String[] args) {
		
		WebDriver driver = getMyDriver("ff");
		launchApp("http://formy-project.herokuapp.com/modal");
		clickOnElement("id", "modal-button");
		String textOnPopUp = getTextOnElement("id", "exampleModalLabel");
		System.out.println(textOnPopUp);
		clickOnElement("id", "close-button");
//		driver.close();
	}
}
