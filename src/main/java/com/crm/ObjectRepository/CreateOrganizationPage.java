package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
	// declartion
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement indTypeDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement submitBtn;
	
	// initilization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt()
	{
		return orgNameEdt;
	}

	public WebElement getIndTypeDropdown()
	{
		return indTypeDropdown;
	}

	public WebElement getTypeDropDown() 
	{
		return typeDropDown;
	}

	public WebElement getSubmitBtn() 
	{
		return submitBtn;
	}
	
	// business library
	
	/**
	 * This method will create the organization
	 * @param orgName
	 */
	public void createNewOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		
		submitBtn.click();
	}
	/**
	 * this method will 
	 * @param orgName
	 * @param indType
	 */
	
	public void createNewOrg(String orgName,String indType)
	{
		orgNameEdt.sendKeys(orgName);
		select(indType, indTypeDropdown);
		submitBtn.click();
		
	}
	
	public void createNewOrg(String orgName, String indType, String type)
	{
		orgNameEdt.sendKeys(orgName);
		select(indType, indTypeDropdown);
		select(type, typeDropDown);
		submitBtn.click();
	}
	
	

}
