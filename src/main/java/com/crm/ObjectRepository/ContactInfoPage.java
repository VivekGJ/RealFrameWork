package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeader() 
	{
		return contactHeader;
	}
	
	//business library
	/**
	 * This method will give the contact header text
	 * @return
	 */
	
	public String contactInfo()
	{
		String contactInfo = contactHeader.getText();
		return contactInfo;
	}
	
	

}
