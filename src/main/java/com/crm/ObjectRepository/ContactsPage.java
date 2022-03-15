package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility
{
	// declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	// Initilization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utlization
	public WebElement getCreateContactLookUpImg()
	{
		return createContactLookUpImg;
	}
	
	//business libraray
	/**
	 * This method will click on Create contact lookUp image
	 */
	
	public void clickOnCreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	
}
