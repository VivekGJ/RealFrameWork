package com.crm.ContactTestcaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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
import com.crm.ObjectRepository.CreateNewContactTPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithImageTest extends BaseClass
{
	@Test
	public void createContactWithTest() throws Throwable 
	{
		
        /*load all the from excel*/
		
		String lastName=eLib.readDataIntoExcel("Contacts", 7, 3);
		
		  /*navigate to contact and create new contact*/
		 HomePage hp=new HomePage(driver);
		 hp.clickOncontactsLnk();
		 
		 ContactsPage cp=new ContactsPage(driver);
		 cp.clickOnCreateContactImg();
		 CreateNewContactTPage cnc= new CreateNewContactTPage(driver);
		 cnc.createContact(lastName, driver);
		 
		 ContactInfoPage cinp= new ContactInfoPage(driver);
		 String conHeader = cinp.contactInfo();
		 
		 Assert.assertTrue(conHeader.contains(lastName));
		 
	}

}
