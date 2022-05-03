package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncongnitoBrowserlaunch 
{
	@Test
	public void incongitoBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("Incognito");
		WebDriver driver= new ChromeDriver(opt);
		driver.get("https://www.google.com");
	}


  
}
