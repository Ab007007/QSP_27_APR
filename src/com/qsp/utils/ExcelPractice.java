package com.qsp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File file = new File("data//actitimedata.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getLastRowNum() + 1;
		for (int i = 0; i < rowCount; i++) {

			Row row = sh.getRow(i);
			Cell cell = row.getCell(0);
			System.out.println(getMyExcelValue(cell));
			Cell cell2 = row.createCell(1);
			cell2.setCellValue("Success");
			
		}

		System.out.println(rowCount);
//		int sheetCount = wb.getNumberOfSheets();
//		System.out.println(sheetCount);
//		for (int i = 0; i < sheetCount; i++) {
//			System.out.println(wb.getSheetName(i));
//		}
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		fis.close();
		fos.close();
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
