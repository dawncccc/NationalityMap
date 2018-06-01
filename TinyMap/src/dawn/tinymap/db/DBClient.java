/*
 * 
 * Copyright(c) 田岑熙  TianCenXi tiancenxi@126.com 2016.10.03-
 * 
 * 
 */
package dawn.tinymap.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClient 
{
	//public static String DB_URL="jdbc:mysql://localhost:3306/login_test";
		public static String DB_URL="jdbc:mysql://localhost:3306/tinymap?useUnicode=true&characterEncoding=UTF-8";
		public static String DB_USER="root";
		public static String DB_PASSWORD="";
		public static Connection getConnection()
		{
			Connection conn = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				conn.setAutoCommit(false);
				return conn;
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return null;
		}
}
