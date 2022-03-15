package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 
{
	@Test(dataProvider = "getData")
	public void sampleDataprovider(String materials, int qty)
	{
		System.out.println(materials+"---"+qty);
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[6][2];
		obj[0][0]="book";
		obj[0][1]=1;
		
		obj[1][0]="pen";
		obj[1][1]=5;
		
		obj[2][0]="pencil";
		obj[2][1]=10;
		
		obj[3][0]="comapss";
		obj[3][1]=3;
		
		obj[4][0]="Bag";
		obj[4][1]=5;
		
		obj[5][0]="Protactor";
		obj[5][1]=20;
		
		
		
		return obj;
		
	}

}
