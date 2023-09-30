package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {

	@Test (priority = 1)
	public void executeScript1() {
		System.out.println("Execute test script - 1");
	}
	
	@Test (dependsOnMethods = "executeScript3")
	public void executeScript2() {
		System.out.println("Execute test script - 2");
	}
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("Connecting to DB");
	}
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("Opening Browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login as admin");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout as admin");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close the browser");
	}
	
	@AfterSuite
	public void closeDB() {
		System.out.println("Close the DB connection");
	}
	
	@Test (priority = 2, dependsOnMethods = "executeScript6")
	public void executeScript3() {
		System.out.println("Execute test script - 3");
	}
	
	@Test(dependsOnMethods = "executeScript5")
	public void executeScript4() {
		System.out.println("Execute test script - 4");
	}
	
	@Test (invocationCount = 0)
	public void executeScript5() {
		System.out.println("Execute test script - 5");
	}
	
	@Test (invocationCount = 2)
	public void executeScript6() {
		System.out.println("Execute test script - 6");
	}
}
