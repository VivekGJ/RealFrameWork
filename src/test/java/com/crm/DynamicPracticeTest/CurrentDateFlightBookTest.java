package com.crm.DynamicPracticeTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;

public class CurrentDateFlightBookTest 
{
	@Test
	public void curretDateFlight()
	{
		SimpleDateFormat date= new SimpleDateFormat("dd/MMMM/yyyy");
		String currentDate = date.format(new Date());
		System.out.println(currentDate);
		String[] spDate = currentDate.split("/");
		String day = spDate[0];
		String mon = spDate[1];
		String year = spDate[2];
		
		System.out.println(day);
	String monthAndYear = mon+" "+year;
	System.out.println(monthAndYear);
		
		
		/*WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		Actions actions=new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		String fromXpath="//span[text()='From']/following-sibling::p[text()='Enter city or airport' and @class='sc-iJKOTD iipKRx fswWidgetPlaceholder']";
	    driver.findElement(By.xpath(fromXpath)).click();
		 
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::input[@type='text']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//span[text()='To']/following-sibling::input[@type='text']"));
		ele.click();
		ele.sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Chhatrapati Shivaji International Airport']")).click();
		String dateXpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		driver.findElement(By.xpath(dateXpath)).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		
		driver.quit();*/
	}

}
