package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;

public class DataProviderReadDataWithType
{
	@Test(dataProvider ="OrgWithTestData")
	public void readDataWithType(String orgName, String indType, String type)
	{
		System.out.println(orgName+" "+indType+" "+type);
		
		
	}
	
	@DataProvider(name="OrgWithTestData")
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] data = eLib.readMultipleDataFromExcel("OrgTestData");
		return data;
	}

}
