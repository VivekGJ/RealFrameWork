package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	//declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img[@title='Select']")
	private WebElement selectReportsLookUpImg;
	
	@FindBy(name = "assigntype")
	private WebElement groupRadioBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignToGroupDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement submitBtn;
	
	@FindBy(name = "imagename")
	private WebElement fileUpImg;
	
	// initilization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization

	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() 
	{
		return orgNameLookUpImg;
	}

	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	public WebElement getSearchNowBtn() 
	{
		return searchNowBtn;
	}

	public WebElement getLeadSorceDropdown() 
	{
		return leadSourceDropdown;
	}

	public WebElement getSelectReportsLookUpImg() 
	{
		return selectReportsLookUpImg;
	}

	public WebElement getGroupRadioBtn() 
	{
		return groupRadioBtn;
	}

	public WebElement getAssignToGroupDropdown() 
	{
		return assignToGroupDropdown;
	}

	public WebElement getSubmitBtn() 
	{
		return submitBtn;
	}
	

	public WebElement getFileUpImg() 
	{
		return fileUpImg;
	}

	// business library
	/**
	 * This method will create the contact
	 * @param lastName
	 */
	 public void createContact(String lastName)
	 {
		 lastNameEdt.sendKeys(lastName);
		 submitBtn.click();
	 }
	
	 /**
	  * This method will create the contact with with Organization 
	  * @param driver
	  * @param lastName
	  * @param orgName
	  */
	public void createContact(WebDriver driver,String lastName,String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		submitBtn.click();
		
		
	}
	/**
	 * This method will create the contact with lead source
	 * @param lastName
	 * @param leadSource
	 */
	public void createContact(String lastName,String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadSource, leadSourceDropdown);
		submitBtn.click();
	}
	
	/**
	 * This method will create the contact with report
	 * @param lastName
	 * @param driver
	 * @param repoCon
	 */
	
	public void createContact(String lastName,WebDriver driver,String creCon)
	{
		lastNameEdt.sendKeys(lastName);
	    selectReportsLookUpImg.click();
	    switchToWindow(driver, "Popup");
	    searchEdt.sendKeys(creCon);
	    searchNowBtn.click();
	    driver.findElement(By.xpath("//a[text()='"+" "+creCon+"']")).click();
	    switchToWindow(driver, "parenttab");
	    submitBtn.click();
	}
	
public void createContact(WebDriver driver)
	
	{
	
		submitBtn.click();
		acceptAlert(driver);
		
	}
	

}
