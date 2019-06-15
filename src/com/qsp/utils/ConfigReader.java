package com.qsp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class ConfigReader {

	public static String getDateAndTime() {
		Date d = new Date();
		String str = d.toString();
		System.out.println(str);
		str = str.replaceAll(":", "_");
		System.out.println(str);
		str = str.replaceAll(" " , "_");
		System.out.println(str);
		return str;
	}

	public static String getConfigValue(String key) throws IOException
	{
		String value = null;

		File file  = new File("data\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		value =  props.getProperty(key);
		fis.close();
		return value;
		
		
	}
}
