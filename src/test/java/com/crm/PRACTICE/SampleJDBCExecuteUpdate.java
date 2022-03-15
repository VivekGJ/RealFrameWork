package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{
	
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException
	{
		Connection con=null;
		try
		{
		// step1 : register the database
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		
		// step 2: get the conncetion from database
		
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stents", "root", "root");
		
		//step3 :issue create staement 
		
		Statement stat = con.createStatement();
		
		// step4: excute query
		// insert into student values(6, 'Wasim', 'Male');
		int result = stat.executeUpdate("insert into student values(6, 'Wasim', 'Male');");
		if(result==1)
		{
			System.out.println("data added sucessfully");
			
		}
		else
		{
			System.out.println("data not added");
		}
	}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	
		finally
		{
			//step 5: close the database
			
			con.close();
		}
		
		
	}

}
