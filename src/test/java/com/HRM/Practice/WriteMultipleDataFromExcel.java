package com.HRM.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataFromExcel {
public static void main(String[] args) throws Throwable {
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\ReadTestData.xlsx");
	
	Workbook wb = WorkbookFactory.create(fi);
	
	Sheet sh = wb.getSheet("Sheet2");
	
	for(int i=2;i<=5;i++)
	{
		         // Row row = sh.createRow(i);
		for (int j=0;j<=1;j++)
		{
			    //sh.getRow(i).createCell(j).setCellValue("Monu");//in this case Monu will be written 
				sh.getRow(i).getCell(j).setCellValue("AshwiniDB");// in this case AswiniDB will be written 
				FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ReadTestData.xlsx");
				wb.write(fos);
		}
	
	}
	
	wb.close();
}
}
