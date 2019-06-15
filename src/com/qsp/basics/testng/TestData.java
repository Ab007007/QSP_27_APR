package com.qsp.basics.testng;

import org.testng.annotations.DataProvider;

public class TestData 
{
	
	 @DataProvider
	  public Object[][] customerdata() {
	    return new Object[][] {
	    	new Object[] { "testng-Customer1","testng-Desc-Customer1"},
	    	new Object[] { "testng-Customer2","testng-Desc-Customer1"},
	    	new Object[] { "testng-Customer3","testng-Desc-Customer1"},
	    	new Object[] { "testng-Customer4","testng-Desc-Customer1"},
	    };
	  }
	 
	 @DataProvider
	  public Object[][] projectdata() {
	    return new Object[][] {
	    	new Object[] { "testng-Customer1","project1", "testng-Desc-Customer1"},
	    	new Object[] { "testng-Customer2","project2", "testng-Desc-Customer1"},
	    	new Object[] { "testng-Customer3","project1", "testng-Desc-Customer1"},
	    	new Object[] { "testng-Customer4","project1", "testng-Desc-Customer1"},
	    };
	  }

}
