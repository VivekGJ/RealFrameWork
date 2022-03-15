package com.crm.ContactsTest;

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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithMultipeDataTest extends BaseClass
{
	
	@Test(dataProvider = "CreateContactWithTestData")
	public void createContactWithMultipleData(String lastName) throws Throwable
	{
	
				//navigate to contact link
				
				HomePage hp=new HomePage(driver);
				hp.clickOncontactsLnk();
				Reporter.log("navigate to contact link",true);
				
				//create contact
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactImg();
				Reporter.log("click on create contact",true);
				
				CreateContactPage ccp=new CreateContactPage(driver);
				ccp.createContact(lastName);
				Reporter.log("create contact with data",true);
				
				//verification
				ContactInfoPage cip=new ContactInfoPage(driver);
				String actualHeader = cip.contactInfo();
				Assert.assertTrue(actualHeader.contains(lastName));
				

	}
	
	@DataProvider(name="CreateContactWithTestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readMultipleDataFromExcel("ContactWithData");
		return data;
	}
}
