package com.qsp.basics.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class AuthenticaitonPopUpDemo {
	
	public static void main(String[] args) throws IOException {
	
		Runtime.getRuntime().exec("D:\\QSP_EclipseWS\\SeleniumPractice\\autoitSctipts\\authenticationHandler.exe");
		WebDriver driver = ActitimeUtils.getMyDriver("ie");
		ActitimeUtils.launchApp("https://www.engprod-charter.net/");
	}

}
