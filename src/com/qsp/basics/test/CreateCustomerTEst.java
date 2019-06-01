package com.qsp.basics.test;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class CreateCustomerTEst {
	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDriver("FF");
		ActitimeUtils.launchApp("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.clickOnModule("tasks");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer("QSP-FirstCust", "QSP-FirstCust-Desc");
		ActitimeUtils.logout();
	}

}
