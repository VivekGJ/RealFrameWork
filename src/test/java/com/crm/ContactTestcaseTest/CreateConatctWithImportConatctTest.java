package com.crm.ContactTestcaseTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateConatctWithImportConatctTest 
{
	@Test
	public void createContactWithImportTest() throws Throwable
	{
		
		Random ran= new Random();
		int random = ran.nextInt(500);
		/*load all the nessary data*/
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		/*load all the nessary data from excel*/
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Contacts");
		Row ro = sh.getRow(9);
		Cell ce = ro.getCell(2);
		String lastName = ce.getStringCellValue()+""+random;
		Row ro1 = sh.getRow(8);
		Cell cel = ro1.getCell(2);
		String newName = cel.getStringCellValue();
		
		
		/*step3: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step 4:login to appliction*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*step 5; navigate to contat link*/
		driver.findElement(By.linkText("Contacts")).click();
		/*step 6: click on create contact button*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		/*create contact and save*/
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		WebElement ele = driver.findElement(By.xpath("//img[@alt='Import Contacts']"));
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_T);
		Set<String> win1 = driver.getWindowHandles();
		String pid = driver.getWindowHandle();
		ArrayList<String> arr= new ArrayList<String>();
		
		WebElement ele1 = driver.findElement(By.id("import_file"));
		ele1.sendKeys("C:\\Users\\VIVEK\\Desktop\\SampleCSVFile_2kb.csv");
		driver.findElement(By.name("next")).click();
		WebElement ele2 = driver.findElement(By.name("mapped_fields"));
		Select s=new Select(ele2);
	    s.selectByValue("lastname");
	    driver.findElement(By.id("lastname_defaultvalue")).sendKeys(newName);
	    driver.findElement(By.name("import")).click();
	    driver.findElement(By.name("cancel")).click();
	  
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headerText.contains(lastName))
	    {
	    	System.out.println(headerText);
	    	System.out.println("contact is created");
	    }
	    else
	    {
	    	System.out.println(headerText);
	    	System.out.println("contact is not created");
	    }
		driver.findElement(By.linkText("Contacts")).click();
		
	}

}
