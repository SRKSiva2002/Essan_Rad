package com.Essan_Rad.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of java related methods
 * @author Sivabalan Selvaraj
 *
 */
public class JavaUtility {

	/**
	 * This methods generates and return random number
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;
	}
	/**
	 * This method generates current system date
	 * @return
	 */
	public String getSystemDate() {
	Date date = new Date();
	return date.toString();
	}
	/**
	 * This method is generates current system date in Day/Date/Month/Year Format
	 * @return
	 */
	public String getSystemDateInFormat1() {
	Date dt = new Date();
	String[] d = dt.toString().split(" ");
	String day = d[0];
	String month = d[1];
	String date = d[2];
	String year = d[5];
	return day+":"+date+":"+month+":"+year;
	}
	/**
	 * This method generates current system date in DD/MM/YYYY HH-MM-SS format
	 * @return
	 */
	public static String getSystemDateinFormat2() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");
		Date date = new Date();
		String dt=dateformat.format(date);
		return dt;
	}
	
	
}
