package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility
{
	//declartion
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	

	//initilization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getHeaderText()
	{
		return headerText;
	}
	
	// business library
	
	public String orgNameInfo()
	{
		String OrgInfo = headerText.getText();
		return OrgInfo;
	}
	

}
