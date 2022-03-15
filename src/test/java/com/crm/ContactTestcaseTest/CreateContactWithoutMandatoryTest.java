package com.crm.ContactTestcaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactTPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithoutMandatoryTest extends BaseClass
{
	@Test
	public void createContactWithoutMandatoryTest() throws Throwable 
	{
		
		/*navigate to contacts link*/
			
			HomePage hp=new HomePage(driver);
			hp.clickOncontactsLnk();
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateContactImg();
			CreateNewContactTPage cnp=new CreateNewContactTPage(driver);
			cnp.createContact(driver);
			String text = cnp.acceptAlertText(driver);
			System.out.println(text);
			wLib.acceptAlert(driver);
				
			/* logout of  the application*/

			hp.signOutOfApp(driver);
			
			/* close the browser*/
			driver.quit();
			
			
	}

}
