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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class CreateConatactWithReportToTest extends BaseClass
{
	@Test
	public void createContactwithReportTest() throws Throwable 
	{
		/*read all the data from excel*/
		String creCon = eLib.readDataIntoExcel("Contacts", 7, 2)+""+jLib.getRandomNumber();
		String repCon = eLib.readDataIntoExcel("Contacts", 8, 2)+""+jLib.getRandomNumber();
			
		/*step 5; navigate to contact link*/
		HomePage hp=new HomePage(driver);
		hp.clickOncontactsLnk();
		/*step 6: click on create contact button*/
	     ContactsPage cp=new ContactsPage(driver);
	     cp.clickOnCreateContactImg();
	     
		/*create contact and save*/
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(creCon);
		
		
		/*Verification*/
		ContactInfoPage cip=new ContactInfoPage(driver);
		String conntactHeader=cip.contactInfo();
		
         Assert.assertTrue(conntactHeader.contains(creCon));
		cp.clickOnCreateContactImg();
		
		CreateContactPage crCp=new CreateContactPage(driver);
		crCp.createContact(repCon, driver, creCon);
		
		String conHeader = cip.contactInfo();
	    Assert.assertTrue(conHeader.contains(repCon));
	}

}
