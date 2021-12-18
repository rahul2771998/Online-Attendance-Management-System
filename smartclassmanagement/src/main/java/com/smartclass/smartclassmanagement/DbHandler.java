package com.smartclass.smartclassmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler {
	
	Connection conn=DbConn.getConnection();
	
	public void getAttendance(int scholar_no, int subject_id) throws SQLException
	{
		try
		{
			String  sql="update attendance set count=1  where scholar_no=1  and  subject_id=1";
		
	    
		Statement stmt = conn.createStatement();

	      
	      /*ResultSet rs = stmt.executeQuery(sql);
	      //System.out.println(rs.getInt("count"));
	      while(rs.next())
	      {
	    	  System.out.println("Hii");
	    	  System.out.println(rs);
	      }
	      */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
	
	

}
