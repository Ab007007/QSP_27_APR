package com.qsp.basics.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qsp.utils.ActitimeUtils;

public class FileUploadPopUp {

	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("D:\\QSP_EclipseWS\\SeleniumPractice\\autoitSctipts\\fileUploadPopUp.exe");
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://formy-project.herokuapp.com/fileupload");
		ActitimeUtils.clickOnElement("xpath", "//button[text()='Choose']");
		
	}
}
