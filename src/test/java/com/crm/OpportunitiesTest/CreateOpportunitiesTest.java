package com.crm.OpportunitiesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateCampaignsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOpportinitiesPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.OpportunityInfoPage;

public class CreateOpportunitiesTest extends BaseClass
{
	@Test(groups = "smokeSuite")
	public void createOpportunitiesTest() throws Throwable
	{
		/*Load all the data from excel*/
		String lastName = eLib.readDataIntoExcel("Opportunities", 1, 2)+""+jLib.getRandomNumber();
		String campignName = eLib.readDataIntoExcel("Opportunities", 1, 3)+""+jLib.getRandomNumber();
		String opporName = eLib.readDataIntoExcel("Opportunities", 1, 4)+""+jLib.getRandomNumber();
		String realatedTo = eLib.readDataIntoExcel("Opportunities", 1, 5);
		String leadSource = eLib.readDataIntoExcel("Opportunities", 1, 6);
	
		
		/*navigate to contact link and save*/
		HomePage hp=new HomePage(driver);
		hp.clickOncontactsLnk();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(lastName);
		
	   ContactInfoPage cip=new ContactInfoPage(driver);
	   String conHeader = cip.contactInfo();
	   
         Assert.assertTrue(conHeader.contains(lastName));
         Reporter.log(conHeader+"--contact is created", true);
        /*navigate to campgign and create camign and save*/
          hp.clickOnMoreLnk(driver);
          hp.clickOnCampignsLnk();
          CampaignsPage campPg=new CampaignsPage(driver);
          campPg.clickOnCampaignsLookUpImg();
          CreateCampaignsPage campcp=new CreateCampaignsPage(driver);
          campcp.createCampaign(campignName);
          CampaignsInfoPage campInf = new CampaignsInfoPage(driver);
          String campignHeader = campInf.campaignInfo();
	    Assert.assertTrue(campignHeader.contains(campignName));
	    Reporter.log(campignHeader+"campaign is created", true);
		/*navigate to opportunity link*/
		hp.clickOnOpportunityLnk();
		OpportunitiesPage op= new OpportunitiesPage(driver);
		op.clickOnCreateOpportuniesImg();
		
		CreateOpportinitiesPage cop=new CreateOpportinitiesPage(driver);
		cop.createOpportinities(opporName, driver, realatedTo, lastName, leadSource, campignName);
	    OpportunityInfoPage oip=new OpportunityInfoPage(driver);
	    String opporHeader = oip.opportunityInfo();
		
	     Assert.assertTrue(opporHeader.contains(opporName));
	     Reporter.log(opporHeader+"opportunity created", true);
	
	}

}
