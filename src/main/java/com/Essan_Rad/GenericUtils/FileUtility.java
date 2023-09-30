package com.Essan_Rad.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * This class consists Methods for handling property file
 * @author Sivabalan Selvaraj
 *
 */
public class FileUtility {

	/**
	 * This method helps to read the data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readPropertyFile(String key) throws Throwable {
		FileInputStream fis= new FileInputStream(PathConstant.PropertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * This method is used to write data into property file
	 * @param key
	 * @param value
	 * @throws Throwable
	 */
	public void writePropertyFile(String key, String value) throws Throwable {
		FileOutputStream fout = new FileOutputStream(PathConstant.PropertyFilePath);
		Properties p = new Properties();
		p.setProperty(key, value);
		p.store(fout, "Write data");
		fout.close();
	}
}
