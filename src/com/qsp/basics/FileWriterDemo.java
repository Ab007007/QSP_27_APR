package com.qsp.basics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {

		File f = new File("data\\abc2.txt");
		System.out.println(f.exists());
		if(!(f.exists()))
		{
			System.out.println("Creating new file");
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw =  new BufferedWriter(fw);
		
	
		bw.write("ABCD");
		bw.newLine();
		bw.write("1234");
		bw.newLine();
		bw.close();
		fw.close();
		System.out.println("END");
		
	}

}
