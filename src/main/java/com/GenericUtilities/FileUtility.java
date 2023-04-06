package com.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
     /**
      * This method is used to read data from excel
     * @return 
      * @throws Throwable
      */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		 String value = pObj.getProperty(key);
		 return value;
	}
}
