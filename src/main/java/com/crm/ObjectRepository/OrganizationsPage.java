package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility
{
	// decalartion
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//initilization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utlization

	public WebElement getCreateOrgLookUpImg() 
	{
		return createOrgLookUpImg;
	}
	
	
	// business libarary
	
	public void clickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}
	

}
