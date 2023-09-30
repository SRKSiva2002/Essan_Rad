package com.Menu_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddMenuSmokeTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String aUrl = p.getProperty("admin_url");
		String aUname = p.getProperty("admin_username");
		String aPwd = p.getProperty("admin_password");
		
		FileInputStream exc= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(exc);
		Sheet sheet = wb.getSheet("Menu");
		int count=sheet.getLastRowNum();
		HashMap<String, String> data = new HashMap<String, String>();
		for (int i = 1; i <=count; i++) {
			String key=sheet.getRow(i).getCell(0).getStringCellValue();
			String value=sheet.getRow(i).getCell(1).getStringCellValue();
			data.put(key, value);
		}
		
		if (browser.contains("chrome")) {
			driver= new ChromeDriver();
		} else if (browser.contains("firefox")) {
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(aUrl);
		driver.findElement(By.name("username")).sendKeys(aUname);
		driver.findElement(By.name("password")).sendKeys(aPwd);
		driver.findElement(By.name("submit")).click();
		
		String pCount = driver.findElement(By.xpath("//p[.='Dishes']/../h2")).getText();
		int pValue = Integer.parseInt(pCount);
		System.out.println(pValue);
		
		driver.findElement(By.xpath("//span[@class='hide-menu' and .='Menu']")).click();
		driver.findElement(By.linkText("Add Menu")).click();
		
		for ( Entry<String, String> d :data.entrySet()) {
			driver.findElement(By.name(d.getKey())).sendKeys(d.getValue());
		}
		WebElement rest = driver.findElement(By.name(sheet.getRow(2).getCell(3).getStringCellValue()));
		Select s = new Select(rest);
		s.selectByVisibleText(sheet.getRow(2).getCell(4).getStringCellValue());
		driver.findElement(By.name(sheet.getRow(1).getCell(3).getStringCellValue())).click();
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
