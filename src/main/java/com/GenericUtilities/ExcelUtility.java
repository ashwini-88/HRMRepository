package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
     /**
      * Read data from the Excel
      * @param Row No
      * @param Cell No
      * @return 
      * @throws Throwable 
      * @author Ashwini
      */
	public String readDataFromExcel(String SheetName,int rowNo,int cellNo) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	/**
	 * This Method is used to get the last row number
	 * to get last row no
	 * @throws Throwable 
	 * @param SheetName
	 */
	public int getLastRowNo(String SheetName) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		//Sheet sh = wb.getSheet(SheetName);
		//int count=sh.getLastRowNum()
		//return count;
        int lastRowNum = wb.getSheet(SheetName).getLastRowNum();
		return lastRowNum;
	}
    /**
     * Write data into into excel sheet
     * @param SheetName
     * @param RowNo
     * @param ColumnNo
     * @param data
     * @throws Throwable
     * @author Ashwini
     * 
     */
	public void writeDataIntoTheExcel(String SheetName,int RowNo ,int ColumnNo,String data ) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fout);
	}
	/**
	 * To get Multiple data from the Excel Using Map
	 * @param SheetName
	 * @return
	 * @author AShwini
	 * @param expData 
	 * @throws Throwable
	 */
	
	public String readExpData(String SheetName, String expData) throws Throwable
    {
    	FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
	    HashMap<String, String> map = new HashMap<String, String>();
	    for(int i=0;i<=count;i++)
	    {
	    	String row = sh.getRow(i).getCell(0).getStringCellValue();
	    	String cell = sh.getRow(i).getCell(1).getStringCellValue();
	    	map.put(row, cell);
	    }
	    return map.get(expData);
    }
	
    public HashMap<String,String> readMultipleData(String SheetName) throws Throwable
    {
    	FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
	    HashMap<String, String> map = new LinkedHashMap<String, String>();
	    for(int i=0;i<=count;i++)
	    {
	    	String row = sh.getRow(i).getCell(0).getStringCellValue();
	    	String cell = sh.getRow(i).getCell(1).getStringCellValue();
	    	map.put(row, cell);
	    }
	    return map;
    }
}
