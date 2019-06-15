package com.qsp.basics.testng;

import org.testng.annotations.Test;

public class DependsOnDemo {

	
	
	@Test
	public void launch()
	{
		
	}
	@Test(dependsOnMethods = "launch")
	public void login()
	{
		
	}
	@Test(dependsOnMethods = {"lanuch","login"})
	public void createCustomer()
	{
		
	}
	
	@Test(dependsOnMethods = {"createCustomer"})
	public void logout()
	{
		
	}
}
