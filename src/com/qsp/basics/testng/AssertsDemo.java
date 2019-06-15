package com.qsp.basics.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertsDemo {

	
	
	@Test
	public void sumOfNumbers()
	{
		int a =10,b=10;
		System.out.println("first");
		Assert.assertEquals((a+b), 20);
		System.out.println("second");
		Assert.assertEquals((a+b), 21);
		System.out.println("end");
	}
}
