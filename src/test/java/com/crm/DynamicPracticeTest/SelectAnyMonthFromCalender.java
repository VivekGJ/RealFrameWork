package com.crm.DynamicPracticeTest;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelectAnyMonthFromCalender 
{
	
	@Test
	public void selectMonth()
	{
		
		String date="25";
		String monthAndYear="December 2022";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		
		driver.get("https://www.makemytrip.com/");
		
		
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		FluentWait wait1=new FluentWait(driver);
		wait1.ignoring(NoSuchElementException.class);
		
		wait1.pollingEvery(5000, TimeUnit.MILLISECONDS);
		
		
		wait1.withTimeout(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		String dateXpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	
	for(;;)
	{
		try 
		{
			driver.findElement(By.xpath(dateXpath)).click();
			break;
		} 
		catch (Exception e) 
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
	}
	
	}

}
