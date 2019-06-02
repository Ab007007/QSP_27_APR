package com.qsp.basics.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;
import com.qsp.utils.ConfigReader;

public class CreateCustomerUsingTextFile {
	
	public static void main(String[] args) throws IOException {
		
		String browser = ConfigReader.getConfigValue("browser");
		String url = ConfigReader.getConfigValue("url");
		String username = ConfigReader.getConfigValue("username");
		String password = ConfigReader.getConfigValue("password");
		
		
		
		WebDriver driver = ActitimeUtils.getMyDriver(browser);
		ActitimeUtils.launchApp(url);
		ActitimeUtils.login(username,password);
		ActitimeUtils.clickOnModule("tasks");
		
		File file  = new File("data\\customerdata.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br  = new BufferedReader(fr);
		String line = null;
		while((line=br.readLine())!=null)
		{
			String[] data = line.split(",");
			ActitimeUtils.clickOnNewCustomerButton();
			ActitimeUtils.createCustomer(data[0],data[1]);
			
		}
		
		br.close();
		fr.close();
		ActitimeUtils.logout();
	}

}
