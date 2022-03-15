package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	// step 1: declration 
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;

	// initilization 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utliziation using getters

	public WebElement getOrganizationLnk() 
	{
		return organizationLnk;
	}

	public WebElement getContactsLnk() 
	{
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() 
	{
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk()
	{
		return productsLnk;
	}

	public WebElement getMoreLnk() 
	{
		return moreLnk;
	}

	public WebElement getCampaignsLnk()
	{
		return campaignsLnk;
	}

	public WebElement getAdminstratorImg() 
	{
		return adminstratorImg;
	}

	public WebElement getSignOutLnk()
	{
		return signOutLnk;
	}
	
	// business librarry
	
	public void clickOnOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void clickOncontactsLnk()
	{
		contactsLnk.click();
	}
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, adminstratorImg);
		signOutLnk.click();
	}
	
	public void clickOnMoreLnk(WebDriver driver)
	{
		mouseHover(driver, moreLnk);
	}
	
	public void clickOnCampignsLnk()
	{
		campaignsLnk.click();
	}
	
	public void clickOnproductsLnk()
	{
		productsLnk.click();
	}
	
	public void clickOnOpportunityLnk()
	{
		opportunitiesLnk.click();
	}
	
	
}
