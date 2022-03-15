package com.crm.DynamicPracticeTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class DateParcticeTest 
{
	@Test
	public void parcticeDate()
	{
		SimpleDateFormat date= new SimpleDateFormat("dd/MMMM/yyyy");
		String currentDate = date.format(new Date());
		System.out.println(currentDate);
		String[] spDate = currentDate.split("/");
		String day = spDate[0];
		String mon = spDate[1];
		String year = spDate[2];
		
		System.out.println(day);
	String monthAndYear = mon+" "+year;
	System.out.println(monthAndYear);
		
	}

}
