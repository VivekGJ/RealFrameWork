package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCVerification 
{
	@Test
	public void sampleJDBCVerificaton() throws SQLException 
	{
		String expData="Vivek";
		
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("conncetion established");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery("select * from student");
		while(result.next())
		{
			String actData = result.getString(2);
			if(expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData+"  data is verified");
				break;
			}
		}
		con.close();
		System.out.println("conncetion is closed");
		
	}

}
