package com.crm.ContactTestcaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass
{
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
	
		/*load all the from excel*/
		String orgName = eLib.readDataIntoExcel("Contacts", 7, 3)+""+jLib.getRandomNumber();
		String lastName = eLib.readDataIntoExcel("Contacts", 7, 2);
		
		/*navigate to  organization and create org*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
		/*verification*/
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		
		String orgHeader =oip.orgNameInfo();
		Assert.assertTrue(orgHeader.contains(orgName));
		/*navigate to contact and create new contact*/
		   hp.clickOncontactsLnk();
		   ContactsPage conp=new ContactsPage(driver);
		   conp.clickOnCreateContactImg();
		   CreateContactPage crcon=new CreateContactPage(driver);
		   crcon.createContact(driver, lastName, orgName);
		   
		 ContactInfoPage cinf=new ContactInfoPage(driver);
		 String conHeader=cinf.contactInfo();
		  Assert.assertTrue(conHeader.contains(lastName));
		 
	}

}
