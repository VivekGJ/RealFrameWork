package com.crm.CreateCampignTest;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignsPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class CreateCampaignWithProductTest extends BaseClass
{
	@Test(groups = "regressionSuite")
	public void createCampignProdTest() throws Throwable 
	{
	
		   /*read all the from excel*/
		String prodName = eLib.readDataIntoExcel("Campigans", 1, 2)+""+jLib.getRandomNumber();
		String campignName = eLib.readDataIntoExcel("Campigans", 1, 3)+""+jLib.getRandomNumber();
	    
	  
		/*navigate to products link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnproductsLnk();
		
		
		/*create the product and save the product*/
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductLookUpImg();
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.createProduct(prodName);
		
		/*verify for the product*/
		ProductInfoPage pip=new ProductInfoPage(driver);
		String prodHeader = pip.productInfo();
		Assert.assertTrue(prodHeader.contains(prodName));
		Reporter.log(prodHeader+" product is created", true);
		/*navigate to campaign*/
		 hp.clickOnMoreLnk(driver);
		 hp.clickOnCampignsLnk();
		 CampaignsPage cp=new CampaignsPage(driver);
		 cp.clickOnCampaignsLookUpImg();
		 
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaign(campignName, driver, prodName);
		 
		 /*verify for the campign*/
		 CampaignsInfoPage cip=new CampaignsInfoPage(driver);
		 String campignHeader = cip.campaignInfo();
		 Assert.assertTrue(campignHeader.contains(campignName));
		 Reporter.log(campignHeader+"campign is created", true);
		
	}
		
}
