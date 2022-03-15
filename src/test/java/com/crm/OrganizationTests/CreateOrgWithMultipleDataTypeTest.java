package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrgWithMultipleDataTypeTest  extends BaseClass
{
	
	@Test(dataProvider = "OrgwithTestData")
	public void createOrgWithIndAndType(String orgName, String indType, String type) throws Throwable
	{
		
		String orgname=orgName+jLib.getRandomNumber();
		
				
				//naviagate to org link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgLnk();
				Reporter.log("navigated to org link",true);
				
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrgImg();
				Reporter.log("click on create org link",true);
				
				CreateOrganizationPage cop= new CreateOrganizationPage(driver);
				cop.createNewOrg(orgname, indType, type);
				
				Reporter.log("Create org with ind and type",true);
				
				// validate
				OrganizationInfoPage iop=new OrganizationInfoPage(driver);
				String actHeader = iop.orgNameInfo();
				Assert.assertTrue(actHeader.contains(orgname));
				Reporter.log("Verification sucessful",true);			
	}
	
	@DataProvider(name="OrgwithTestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readMultipleDataFromExcel("OrgTestData");
		return data;
	}

}
