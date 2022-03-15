package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;

public class DataProviderContactData 
{
	@Test(dataProvider = "ContactWithData")
	public void createConatctWithData(String lastName)
	{
		System.out.println(lastName);
	}
	@DataProvider(name="ContactWithData")
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] data = eLib.readMultipleDataFromExcel("ContactWithData");
		return data;
	}

}
