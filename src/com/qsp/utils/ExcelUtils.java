package com.qsp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	
	public static String getMyCellValue(String sn,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		String cellValue =null;
		File file  =  new File("data//actitimedata.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sn);
		
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		cellValue =  getMyExcelValue(cell);
	
		fis.close();
		return cellValue;
			
	}
	public static int getMyRowCount(String sn) throws EncryptedDocumentException, IOException
	{
		int  rowCount =0;
		File file  =  new File("data//actitimedata.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sn);
		
		rowCount = sh.getLastRowNum()+1;
		
	
		fis.close();
		return rowCount;
			
	}
	
	public static String getMyExcelValue(Cell cell) {
		String obj = null;
		switch (cell.getCellType().toString()) {
		case "STRING":
			obj = cell.getStringCellValue();
			break;
		case "NUMERIC":
			obj = String.valueOf(cell.getNumericCellValue());
			break;
		case "BOOLEAN":
			obj = String.valueOf(cell.getBooleanCellValue());
			break;
		case "FORMULA":
			obj = String.valueOf(cell.getCellFormula());
			break;
		default:
			System.out.println("Please contact Framework developers....");
			break;
		}
		return obj;
	}
}
