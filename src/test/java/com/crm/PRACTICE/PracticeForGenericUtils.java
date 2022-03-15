package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils 
{
	@Test
	public void practiceForGenericUtilsTest() throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		int random = jLib.getRandomNumber();
		System.out.println(random);
		String date = jLib.getSystemDate();
		System.out.println(date);
		String dat = jLib.getSystemDateInFormat();
		System.out.println(dat);
		
		
		PropertyFileUtility pLib=new PropertyFileUtility();
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		
		ExcelUtility eLib= new ExcelUtility();
		String value = eLib.readDataIntoExcel("Contacts", 1, 1);
		System.out.println(value);
	}
	

}
