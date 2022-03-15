package com.crm.DynamicPracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookFlightGoibiboTest 
{
	@Test
	public void bookFlightGo()
	{
		
		String date="12";
		String yearAndMonth="March 2022";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		Actions actions=new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		String fromXpath="//span[text()='From']/following-sibling::p[text()='Enter city or airport' and @class='sc-iJKOTD iipKRx fswWidgetPlaceholder']";
	    driver.findElement(By.xpath(fromXpath)).click();
		 
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::input[@type='text']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
		//String toXpath="//span[text()='To']/following-sibling::p[text()='Enter city or airport' and @class='sc-iJKOTD iipKRx fswWidgetPlaceholder']";
	    //driver.findElement(By.xpath(toXpath)).click();
		WebElement ele = driver.findElement(By.xpath("//span[text()='To']/following-sibling::input[@type='text']"));
		ele.click();
		ele.sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Chhatrapati Shivaji International Airport']")).click();
		String dateXpath="//div[text()='"+yearAndMonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(dateXpath)).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
	}
	

}
