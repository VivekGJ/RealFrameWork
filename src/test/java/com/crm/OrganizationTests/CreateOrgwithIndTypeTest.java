package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Random;
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
import org.testng.Reporter;
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

public class CreateOrgwithIndTypeTest extends BaseClass
{
	@Test(groups = "smokeSuite")
	public void createOrgwithIndDropdownTest() throws Throwable
	{
		/*load the all the nessary data from excel*/
		
		String orgName = eLib.readDataIntoExcel("Org", 4, 2)+""+jLib.getRandomNumber();
		String indType = eLib.readDataIntoExcel("Org", 4, 3);
	
		
		/*step5: navigate to organization link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		/*click on create organization button*/
		
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		/*enter the mandatory field  and select industry type as healthcare and save*/
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName, indType);
		
		/*verification*/
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgHeader = oip.orgNameInfo();
		 Assert.assertTrue(actOrgHeader.contains(orgName));
		 Reporter.log(actOrgHeader+"org is created", true);
		
		
		
		}

}
