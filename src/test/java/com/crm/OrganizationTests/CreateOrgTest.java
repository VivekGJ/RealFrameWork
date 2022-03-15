package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrgTest extends BaseClass
{
	@Test
	public void createOrgtest() throws Throwable
	{
		
		
		/* step2: read all the neassry data from exel*/
		String orgName = eLib.readDataIntoExcel("Org", 1, 2)+""+jLib.getRandomNumber();
		
		/*step5: navigate to organization link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		/*click on create organization button*/
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		/*enter the mandatory field and save*/
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
	}

}
