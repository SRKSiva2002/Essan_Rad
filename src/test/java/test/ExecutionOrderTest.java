package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExecutionOrderTest {

	@BeforeSuite
	public void beforeSuite1() {
		System.out.println("Before suite 1");
	}
	
	@BeforeClass
	public void beforeClass1() {
		System.out.println("Before class-1");
	}
	@BeforeTest
	public void beforeTest1() {
		System.out.println("Before Test-1");
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("Before Method-1");
	}
	
	@Test
	public void test1() {
		System.out.println("Test - 1");
	}
	
	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("Before Method-2");
	}
	
	@AfterMethod
	public void afterMethod1() {
		System.out.println("After Method-1");
	}
	
	@BeforeMethod
	public void beforeMethod3() {
		System.out.println("Before Method-3");
	}
	
	@AfterMethod
	public void afterMethod2() {
		System.out.println("After Method-2");
	}
	
	@Test
	public void test2() {
		System.out.println("Test - 2");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("After class-1");
	}
	
	@AfterSuite
	public void afterSuite1() {
		System.out.println("After Suite-1");
	}
	
	@AfterTest
	public void afterTest1() {
		System.out.println("After Test-1");
	}
	
}
