package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParcticeTestNg 
{
	
	@Test(invocationCount = 3)
	public void createOrg()
	{
		System.out.println("org is created");
		
	}
	
	@Test(dependsOnMethods = "createOrg")
	public void modifyOrg()
	{
		System.out.println("org is Modified");
	}
	@Test(enabled = false)
	public void deleteOrg()
	{
		System.out.println("org is deleted");
	}

}
