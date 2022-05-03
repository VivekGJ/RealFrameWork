package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class DebugPracticeGen 
{
	@Test
	public void demo()
	{
		System.out.println("hello world");
		DebugPracticeGen dp= new DebugPracticeGen();
		dp.div(1, 0);
	}
	
	public int div(int a, int b)
	{
		int c= a/b;
		return c;
	}

}
