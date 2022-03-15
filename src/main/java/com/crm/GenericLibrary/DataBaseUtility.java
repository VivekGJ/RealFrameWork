package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;



/**
 * This class consists of generic methods which helps to connect the database and read the data
 *  from database and close the connection
 * @author VIVEK
 *
 */

public class DataBaseUtility 
{
	Connection con=null;
	/**
	 * This method will register the driver and establish the connection with database
	 * 
	 * @throws Throwable 
	 */
	public void connectToDb() throws Throwable 
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
	    con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);	
		
	}
	/**
	 * This method will execute the query and return the matching data to the user
	 * @return 
	 * @return
	 * @throws Throwable 
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData ) throws Throwable 
	{
		String data=null;
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;  // flag rising
				break;
			}
			
		}
		if(flag)
		{
			System.out.println(data+"---->data is verified");
			return expData;
		}
		else
		{
			System.out.println("data is not verified");
			return "";
		}
		
		
	}
	/**
	 * This method will close the DB connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	
	

}
