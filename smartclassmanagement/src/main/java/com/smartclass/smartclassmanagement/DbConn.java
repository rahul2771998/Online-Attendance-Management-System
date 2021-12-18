package com.smartclass.smartclassmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {


    private  static  Connection con = null; 
  
    static 
    { 
         String url="jdbc:mysql://localhost:3306/smartclass?useSSL=true";
        String user ="root";
        String pass="";
        try { 
             Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass); 
            
        } 
        catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
    public static Connection getConnection() 
    { 
        return con; 
    } 
} 