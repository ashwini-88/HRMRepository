package com.HRM.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
public static void main(String[] args) throws Throwable {
		
	//create object for Physical File 
	FileInputStream fis = new FileInputStream("./src/test/resources/ReadTestData.xlsx");
	
	//get WorkBook
	Workbook wb = WorkbookFactory.create(fis);
	
	//get the sheet
	Sheet sh = wb.getSheet("Sheet1");
	
	//get Row 
	Row row = sh.getRow(1);
	
	//get cell 
	Cell cell = row.getCell(0);
	
	//get the value
	String value = cell.getStringCellValue();
	System.out.println(value);
}
}
