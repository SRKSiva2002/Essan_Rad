package com.Essan_Rad.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver iDriver;
	public WebdriverUtility wLib = new WebdriverUtility();
	public ExcelUtitlity eLib = new ExcelUtitlity();
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public DataBaseUtility dLib = new DataBaseUtility();

	@BeforeSuite (alwaysRun = true)
	public void configureBeforeSuite() throws Throwable {
		dLib.connectToDB();
		System.out.println("Connecting database");
	}

	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configureBeforeClass() throws Throwable {
	String browser = fLib.readPropertyFile("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Launching Chrome browser");
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Launching FireFox browser");
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("Launching Edge browser");
		}else {
			System.out.println("Invalid Browser");
		}
		iDriver=driver;
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWaitByFindElement(driver, 10);
	}

	@AfterClass(alwaysRun = true)
	public void configureAfterClass() throws Throwable {
		driver.quit();
		System.out.println("Closing the browser");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configureAfterSuite() throws Throwable {
		dLib.closeDB();
		System.out.println("Closing the database");
	}
}
