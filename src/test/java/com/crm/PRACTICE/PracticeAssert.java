package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeAssert 
{
	@Test
	public void practiceAssert() 
	{
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1, 0);
		System.out.println("test script 1");
		Assert.assertEquals(1, 0);
		System.out.println("tes script is passed");
		
		
	}

}
