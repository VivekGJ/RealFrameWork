package com.crm.DynamicPracticeTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ContactCheckBoxSelectTest extends BaseClass
{
	@Test
	public void conatactCheckBoxSelecltAllTest()
	{
		HomePage hp= new HomePage(driver);
		hp.clickOncontactsLnk();
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		int count = checkBoxes.size();
		for(int i=0; i<count;i++)
		{
			WebElement cb = checkBoxes.get(i);
			cb.click();
			boolean b = cb.isSelected();
			Assert.assertEquals(b, true);
		}
		
		
	}
	

}
