package com.qsp.basics.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;
import com.qsp.utils.ConfigReader;
import com.qsp.utils.ExcelUtils;

public class CreateCustomerUsingExcelFile {
	
	public static void main(String[] args) throws IOException {
		
		String browser = ConfigReader.getConfigValue("browser");
		String url = ConfigReader.getConfigValue("url");
		String username = ConfigReader.getConfigValue("username");
		String password = ConfigReader.getConfigValue("password");
		
		
		
		WebDriver driver = ActitimeUtils.getMyDriver(browser);
		ActitimeUtils.launchApp(url);
		ActitimeUtils.login(username,password);
		ActitimeUtils.clickOnModule("tasks");
		
		int rowcount = ExcelUtils.getMyRowCount("customerdata");
		String customerName;
		String customerDesc;
		for (int i = 1; i < rowcount; i++) {
			customerName = null;
			customerDesc = null;
			customerName = ExcelUtils.getMyCellValue("customerdata", i, 0);
			customerDesc = ExcelUtils.getMyCellValue("customerdata", i, 1);
			ActitimeUtils.clickOnNewCustomerButton();
			ActitimeUtils.createCustomer(customerName,customerDesc);
			
		}
	}

}
