package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice
{

	@Test
	public void propertyFile() throws IOException
	{
		// read the file
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//create the object of properties
		
		Properties pObj= new Properties();
		pObj.load(fis);
		
		//step3 : read the data
		
		String BROWSER = pObj.getProperty("browser");
		
		// step4: verification
		
		System.out.println(BROWSER);
		
		
	}
}
