package com.qsp.basics.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qsp.basics.testng.TestData;
import com.qsp.utils.ActitimeUtils;

public class CreateCustomerUsingDP {
	
	WebDriver driver = null;
	
	
	@BeforeClass
	public void setup()
	{
		driver = ActitimeUtils.getMyDriver();
		
	}
	@Parameters({"url","username","password"})
	@Test
	public void preCondition(String url,String un,String pwd)
	{
		ActitimeUtils.launchApp(url);
		ActitimeUtils.login(un, pwd);
		ActitimeUtils.clickOnModule("tasks");
	}
	@Test(dependsOnMethods ="preCondition",dataProvider = "customerdata" ,dataProviderClass = TestData.class)
	public void createMultipleCustomer(String customerName,String customerDesc)
	{
		
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer(customerName,customerDesc);
	
	}
	
	
	@AfterClass
	public void cleanup()
	{
		ActitimeUtils.logout();
		driver.close();
	}
}
