package com.qsp.basics.testng;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GlobalDataDemo {

	@Parameters({"url"})
	@Test
	public void launch(String u)
	{
		Reporter.log("Launching applicaion with " + u);
	}
	
	@Parameters({"username","password"})
	@Test
	public void login(String un,String pwd)
	{
		Reporter.log("username " + un  +  " and password " + pwd);
	}
	
	
}
