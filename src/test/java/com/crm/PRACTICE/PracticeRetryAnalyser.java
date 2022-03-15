package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser 
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void retryAnalyserPractice()
	
	{
		System.out.println("test script 1");
		Assert.fail();
		System.out.println("test script is passed");
	}

}
