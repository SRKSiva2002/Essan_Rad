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

public class EditMenuAndView_GenericUtilsTest {

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
		String uUrl=fLib.readPropertyFile("user_url");
		String uUname = fLib.readPropertyFile("user_username");
		String uPwd = fLib.readPropertyFile("user_password");
		
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
		
		driver.findElement(By.xpath("//span[@class='hide-menu' and .='Menu']")).click();
		driver.findElement(By.linkText("Add Menu")).click();
		
		eLib.readMultipleDataFromExcel("Menu", 0, 1);
		
		WebElement rest = driver.findElement(By.name(eLib.readDataFromExcelFile("Menu",	2, 3)));
		wLib.selectDropDown(eLib.readDataFromExcelFile("Menu", 2, 4), rest);
		
		driver.findElement(By.name(eLib.readDataFromExcelFile("Menu", 1, 3))).click();
		
		String aMenu=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String eMenu="New Dish Added";
		if (aMenu.contains(eMenu)) {
			System.out.println("New Menu is added to Restaurant");
		}
		else {
			System.out.println("New Menu is not added to Restaurant");
		}
		driver.findElement(By.linkText("All Menues")).click();
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[*]/a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		driver.findElement(By.name("d_name")).clear();
		driver.findElement(By.name("price")).clear();
		eLib.readMultipleDataFromExcel("Edit-Menu", 0, 1);
		
		WebElement rest1 = driver.findElement(By.name(eLib.readDataFromExcelFile("Edit-Menu",2, 3)));
		wLib.selectDropDown(eLib.readDataFromExcelFile("Edit-Menu", 2, 4), rest1);
		
		driver.findElement(By.name(eLib.readDataFromExcelFile("Edit-Menu", 1, 3))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='hide-menu' and .='Menu']")).click();
		driver.findElement(By.linkText("All Menues")).click();
		String updatedText = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		String expect=eLib.readDataFromExcelFile("Edit-Menu", 1, 1);
		if (updatedText.contains(expect)) {
			System.out.println("Menu is Updated");
		}
		else {
			System.out.println("Menu is not updated");
		}
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		driver.get(uUrl);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(uUname);
		driver.findElement(By.name("password")).sendKeys(uPwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.partialLinkText("Restaurants")).click();
		WebElement tRest = driver.findElement(By.linkText(eLib.readDataFromExcelFile("Edit-Menu", 2, 4)));
		wLib.scrollDownToElement(driver, tRest);
		driver.findElement(By.xpath("//a[.='"+eLib.readDataFromExcelFile("Edit-Menu", 2, 4)+"']/ancestor::div[contains(@class,'text-xs-center text-sm-left')]/following-sibling::div[1]//a[.='View Menu']")).click();
		if (updatedText.contains(eLib.readDataFromExcelFile("Edit-Menu", 1, 1))) {
			System.out.println("Menu is updated and getting visible in user page");
		} else {
			System.out.println("Menu is updated but not visible in user page");
		}
		wLib.closeAllTheWindows(driver);
	}
}
