package com.crm.ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateContactWithLeadSourceTest extends BaseClass
{
	@Test(groups = "regressionSuite")
	public void createContactWithLeadSourceTest() throws Throwable
	{
		
		/*load the data from excel*/
		String lastName = eLib.readDataIntoExcel("Contacts", 12, 2)+""+jLib.getRandomNumber();
		String leadSource = eLib.readDataIntoExcel("Contacts", 12, 3);
		
		/*step 5; navigate to contat link*/
		  HomePage hp=new HomePage(driver);
		  hp.clickOncontactsLnk();
		  Assert.fail();
		  
		/*step 6: click on create contact button*/
		 ContactsPage cp=new ContactsPage(driver);
		 cp.clickOnCreateContactImg();
		 
		 CreateContactPage ccp= new CreateContactPage(driver);
		 ccp.createContact(lastName, leadSource);
		 
		 /*verification*/
		 
		 ContactInfoPage cip= new ContactInfoPage(driver);
		 String ConHeader = cip.contactInfo();
		 Assert.assertTrue(ConHeader.contains(lastName));
		 
		 
		 
		 
		 
	}

}
