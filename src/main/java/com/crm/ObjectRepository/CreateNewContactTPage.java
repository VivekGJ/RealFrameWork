package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContactTPage extends WebDriverUtility
{

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement submitBtn;
	
	@FindBy(name = "imagename")
	private WebElement fileUpImg;
	
	// initilization
	public CreateNewContactTPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getSubmitBtn() 
	{
		return submitBtn;
	}

	public WebElement getFileUpImg() 
	{
		return fileUpImg;
	}
	
	public String createContact(WebDriver driver)
	
	{
	
		submitBtn.click();
		String text = acceptAlertText(driver);
		return text;
		
	}
	public void createContact(String lastName, WebDriver driver)
	{
		lastNameEdt.sendKeys(lastName);
		scrollAction(driver, fileUpImg);
		fileUpImg.sendKeys("C:\\Users\\VIVEK\\Desktop\\photo-1515041219749-89347f83291a.jpg");
		scrollAction(driver, submitBtn);
		submitBtn.click();
	}
	
	
}
