package com.HRM.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToAnExcel {
public static void main(String[] args) throws Throwable {
	 FileInputStream fi = new FileInputStream("./src/test/resources/ReadTestData.xlsx");
	
		Workbook wb = WorkbookFactory.create(fi);
		
	    Sheet sh = wb.getSheet("Sheet3");
	    
		Row row = sh.createRow(1);  //In some system// Row row = sh.getRow(2); is working
	  
		Cell cell = row.createCell(0);
	    
	    cell.setCellValue("TestWell");
	    
	    FileOutputStream fout = new FileOutputStream("./src/test/resources/ReadTestData.xlsx");
	    wb.write(fout);
	    wb.close();
	    }
}
