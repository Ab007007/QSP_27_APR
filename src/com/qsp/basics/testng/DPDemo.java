package com.qsp.basics.testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DPDemo {
  @Test(dataProvider = "customerdata" , dataProviderClass = TestData.class)
  public void createCustomerTest(String s1, String s2) {
	  System.out.println(s1 + " -- " + s2);
  }

 
}
