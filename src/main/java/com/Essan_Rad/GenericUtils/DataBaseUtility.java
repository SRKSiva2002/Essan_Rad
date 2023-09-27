package com.Essan_Rad.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * This class has methods to handle with database
 * @author Sivabalan Selvaraj
 *
 */
public class DataBaseUtility {

	Connection con= null;
	/**
	 * This method helps to connect to database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(PathConstant.dbUrl, PathConstant.dbUsername, PathConstant.dbPassword);
	}
	/**
	 * This method is used to execute the query and validate the data
	 * @param query
	 * @param colNum
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int colNum, String expData) throws Throwable {
		ResultSet res = con.createStatement().executeQuery(query);
		boolean f=false;
		while (res.next()) {
			String data=res.getString(colNum);
			if (data.equalsIgnoreCase(expData)) {
				f=true;
				break;
			}
			if (f==true) {
				System.out.println("Data is verified");
			} else {
				System.out.println("Data is not verified");
			}
		}
		return "";
	}
	/**
	 * This method is used to close the database
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
	
}
