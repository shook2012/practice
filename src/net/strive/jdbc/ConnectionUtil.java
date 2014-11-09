package net.strive.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil{
	public Connection openConnection() {
		  
		  String driver = "";
		  String url = "";
		  String user = "";
		  String password = "";
		  Properties prop = new Properties();
		  Connection conn = null;
		  try {
		   // 加载属性文件
		   prop.load(this.getClass().getClassLoader().getResourceAsStream(
		     "DBConfig.properties"));
		   driver = prop.getProperty("driver");
		   url = prop.getProperty("url");
		   user = prop.getProperty("user");
		   password = prop.getProperty("password");

		   // Class.forName加载驱动
		   Class.forName(driver);

		   // DriverManager获得连接
		   conn = DriverManager.getConnection(url,user, password);
		   return conn;
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return null;
		 }
}
