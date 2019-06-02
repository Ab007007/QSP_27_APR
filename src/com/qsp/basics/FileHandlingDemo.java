package com.qsp.basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandlingDemo {

	public static void main(String[] args) throws IOException {
		
		File file  =  new File("data\\abc.txt");
		FileReader fr  = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
			
		String line = null;
		
		while((line=br.readLine())!=null)
		{
			System.out.println(line);
		}
		
		br.close();
		fr.close();
		
	}
	
	public static void printFileInfo(File file)
	{

		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.canRead());
		
		File[] files = file.listFiles();
		
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		
	}
}
