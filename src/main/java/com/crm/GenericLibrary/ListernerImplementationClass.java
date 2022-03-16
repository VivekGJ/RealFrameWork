package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListernerImplementationClass implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test= report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
	      test.log(Status.PASS, MethodName+"----->passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		String path=null;
		String methodName = result.getMethod().getMethodName()+"-";
		Reporter.log(methodName+"-----TestScript failed", true);
		
		// step 1: configure screeshot name
		String screeshotName = methodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screeshotName);
		
		// step 2: using screeshot method from webdriver utility
		
		
		
		try 
		{
			path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screeshotName);
			
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
		test.log(Status.FAIL, methodName+"---->skipped");
		// it will capture the exception and log it report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
	     test.log(Status.SKIP, methodName+"------>Skipped");
	     test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		/*Execution will start here*/
		//configure the report
		ExtentSparkReporter htmlReport= new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium execution report");
		
		report= new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Url", "http://localhost:8888");
		report.setSystemInfo("Reporter-name", "Vivekananda");
		
		
	
		
	}

	public void onFinish(ITestContext context) 
	{
		//consolidate all the parameters and genarate the report
		
		report.flush();
		
	}

	
}
