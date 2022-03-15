package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery 
{
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
		// step1: register the database
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		
		//step2: get conncetor from database - provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//step 3 : issue create statement
		
		Statement stat = con.createStatement();
		
		// step 4 : execute query
		
		ResultSet result = stat.executeQuery("select * from student;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		// step 5 : close the databse
		con.close();
		
	}

}
