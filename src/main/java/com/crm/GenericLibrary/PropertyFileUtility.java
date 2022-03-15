package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class will be read data from Property file and return value to user
 * @author VIVEK
 *
 */

public class PropertyFileUtility 
{
	/**
	 * This method will read data from property file for the key given by user and return value to user 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.FilePath);
		Properties pLib=new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
	}

}
