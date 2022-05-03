package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class DemoTest 
{
	@Test(priority = 1)
	public void test1()
	{
		System.out.println("this is test 1");
	}
	@Test
	public void test2()
	{
		System.out.println("this is test 2");
	}
	@Test(priority = 3)
	public void test3()
	{
		System.out.println("this is test 3");
	}



}
