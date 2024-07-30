package com.user.Util;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DBUtil {

public static Connection getConnection()

{

 String url="jdbc:mysql://localhost:3306/mphasis";

 String username="root";

 String password="Password@12";

 Connection con=null;

 try {

 con= DriverManager.getConnection(url,username,password);

 } catch (SQLException e) {

 // TODO Auto-generated catch block

 e.printStackTrace();

 }

 return con;

}

}