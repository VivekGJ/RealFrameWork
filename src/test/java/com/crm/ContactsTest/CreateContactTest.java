package com.crm.ContactsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
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


@Listeners(com.crm.GenericLibrary.ListernerImplementationClass.class)
public class CreateContactTest extends BaseClass
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void createContactTest() throws Throwable
	{
			
		/* step2: read all the neassry data from excel*/
		String lastName = eLib.readDataIntoExcel("Contacts", 1, 2)+" "+jLib.getRandomNumber();
	
		/*step 5; navigate to contat link*/
		  HomePage hp=new HomePage(driver);
		  hp.clickOncontactsLnk();
		/*step 6: click on create contact button*/
		 ContactsPage cp=new ContactsPage(driver);
		 cp.clickOnCreateContactImg();
		 String expData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 String actData="Creating New Contact";
		 Assert.assertEquals(actData, expData);
		 
	
		/* enter the data into the mandatory field*/
		
		CreateContactPage cc=new CreateContactPage(driver);
		cc.createContact(lastName);
		
		/* verification*/
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actContactHeader = cip.contactInfo();
		Assert.assertTrue(actContactHeader.contains(lastName));
	}

}
