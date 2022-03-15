package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataintoExcelSheetTest 
{
	@Test
	public void writeDataIntoExcelSheetTest() throws EncryptedDocumentException, IOException
	{
		//open file in read mode
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Sheet1");
	    Row ro = sh.getRow(0);
	    
	    //create the cell to write the data
	    
	    Cell ce = ro.createCell(9);
	    
	    //set a cell value
	    ce.setCellValue("tc_1000");
	    
	    //open the file write mode
	    FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
	    wb.write(fos);
	 
		
		
	}

}
