package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
@Listeners(com.crm.GenericLibrary.ListernerImplementationClass.class)
public class CreateOrgWithIndAndTypeTest extends BaseClass
{
	@Test(groups = "regressionSuite")
	public void createOrgWithIndAndType() throws Throwable
	{
		/*load all the data from */
		
		String OrgName = eLib.readDataIntoExcel("Org", 7, 2)+" "+jLib.getRandomNumber();
		String indType = eLib.readDataIntoExcel("Org", 7, 3);
		String type = eLib.readDataIntoExcel("Org", 7, 4);
	
		
		/*naviagte to Organization link*/
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLnk();
		Assert.fail();
		
		/*click on create org*/
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		/*create contact*/
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName, indType, type);
	    
		/*verification*/
		
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String orgHeader = oip.orgNameInfo();
        Assert.assertTrue(orgHeader.contains(OrgName));
        Reporter.log(orgHeader+"org is created");
	
	/*@Test
	public void testScript2()
	{
		System.out.println("this test script 2");
	}
	
	@Test
	public void sampleTestScript()
	{
		System.out.println("Sample test script");
	}
	
	@Test
	public void sampleTestScript1()
	{
		System.out.println("Sample test script 1");
	}
	@Test
	public void sampleTestScript2()
	{
		System.out.println("Sample test script 2");
	}
*/

}
}