package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class ListernerImplementationClass implements ITestListener
{

	public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"-----Testscript execution started");
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"-----Testscript execution sucessfull-PASS");
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName()+"-";
		Reporter.log(methodName+"-----TestScript failed", true);
		
		// step 1: configure screeshot name
		String screeshotName = methodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screeshotName);
		
		// step 2: using screeshot method from webdriver utility
		
		try 
		{
			new WebDriverUtility().getScreenShot(BaseClass.sDriver, screeshotName);
			
			/*EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sDriver);
			File src = eDriver.getScreenshotAs(OutputType.FILE);
			String pa = System.getProperty("user.dir")+"/Screeshots/"+screeshotName+".png";
			String path="./Screeshots/"+screeshotName+".png";
			File dst=new File(path);
			Files.copy(src, dst);*/
		} 
		catch (Throwable e) 
		{
		
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"-----Testscript is skipped",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}

	
}
