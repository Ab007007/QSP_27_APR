package com.qsp.basics.testng;

import org.testng.annotations.Test;

public class FirstTestNG {

	@Test
	public void launch() {
		System.out.println("Launch ");
	}

	@Test(dependsOnMethods = "launch")
	public void login() {
		System.out.println("login");
	}

	@Test(dependsOnMethods = "login")
	public void createCustomer() {
		System.out.println("create customer");
	}

	@Test(dependsOnMethods = "createCustomer")
	public void createProject() {
		System.out.println("create Project");
	}

	@Test(dependsOnMethods = "createProject")
	public void logout() {
		System.out.println("Logout");
	}
}
