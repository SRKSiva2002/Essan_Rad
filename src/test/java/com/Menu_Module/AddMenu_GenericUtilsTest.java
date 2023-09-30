package com.Menu_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Essan_Rad.GenericUtils.DataBaseUtility;
import com.Essan_Rad.GenericUtils.ExcelUtitlity;
import com.Essan_Rad.GenericUtils.FileUtility;
import com.Essan_Rad.GenericUtils.JavaUtility;
import com.Essan_Rad.GenericUtils.WebdriverUtility;

public class AddMenu_GenericUtilsTest {

	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		//object for all utility file
		WebdriverUtility wLib= new WebdriverUtility();
		JavaUtility jLib =  new JavaUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtitlity eLib=new ExcelUtitlity();
		DataBaseUtility dLib=new DataBaseUtility();
		
		//read data from excel file
		String browser = fLib.readPropertyFile("browser");
		String aUrl = fLib.readPropertyFile("admin_url");
		String aUname = fLib.readPropertyFile("admin_username");
		String aPwd = fLib.readPropertyFile("admin_password");
		
		//Open browser
		if (browser.contains("chrome")) {
			driver= new ChromeDriver();
		} else if (browser.contains("firefox")) {
			driver= new FirefoxDriver();
		}
		
		//maximize and login
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWaitByFindElement(driver, 10);;
		driver.get(aUrl);
		driver.findElement(By.name("username")).sendKeys(aUname);
		driver.findElement(By.name("password")).sendKeys(aPwd);
		driver.findElement(By.name("submit")).click();
		
		String pCount = driver.findElement(By.xpath("//p[.='Dishes']/../h2")).getText();
		int pValue = Integer.parseInt(pCount);
		System.out.println(pValue);
		
		driver.findElement(By.xpath("//span[@class='hide-menu' and .='Menu']")).click();
		driver.findElement(By.linkText("Add Menu")).click();
		
		eLib.readMultipleDataFromExcel("Menu", 0, 1);

		WebElement rest = driver.findElement(By.name(eLib.readDataFromExcelFile("Menu",	2, 3)));
		wLib.selectDropDown(eLib.readDataFromExcelFile("Menu", 2, 4), rest);
		
		driver.findElement(By.name(eLib.readDataFromExcelFile("Menu", 1, 3))).click();
		driver.findElement(By.xpath("//span[.='Dashboard']")).click();
		String aCount = driver.findElement(By.xpath("//p[.='Dishes']/../h2")).getText();
		int aValue = Integer.parseInt(aCount);
		System.out.println(aValue);
		if (pValue<aValue) {
			System.out.println("Menu is added");
		} else {
			System.out.println("Menu is not added");
		}
		driver.quit();
	}
}
