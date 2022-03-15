package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider = "getData")
	public void sampleDataProvider(String mobile, String model, int qty)
	{
		System.out.println(mobile+"----"+model+"----"+qty);
		
	}
	
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj= new Object[4][3];
		
		obj[0][0]="Mi";
		obj[0][1]="max 14";
		obj[0][2]=10;
		
		obj[1][0]="Vivo";
		obj[1][1]="12 max";
		obj[1][2]=12;
		
		obj[2][0]="Samsung";
		obj[2][1]="S8";
		obj[2][2]=20;
		
		obj[3][0]="Iphone";
		obj[3][1]="11 pro";
		obj[3][2]=14;
		
		return obj;
		
		
	}

}
