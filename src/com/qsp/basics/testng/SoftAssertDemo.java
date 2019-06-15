package com.qsp.basics.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	
	
	@Test
	public void sumOfNumbers()
	{
		SoftAssert sa  = new SoftAssert();
		int a =10,b=10;
		System.out.println("first");
		sa.assertEquals((a+b), 2);
		System.out.println("second");
		sa.assertEquals((a+b), 21);
		System.out.println("end");
		
		sa.assertAll();
	}
}
