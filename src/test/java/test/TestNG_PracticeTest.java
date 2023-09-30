package test;


import org.testng.annotations.Test;

public class TestNG_PracticeTest {

	@Test 
	public void openBrowser() {
		int a=10/0;
		System.out.println("openBrowser");
	}
	
	@Test(enabled = false)
	public void loginAsAdmin() {
		System.out.println("Login as Admin");
	}
	
	@Test (priority = 1)
	public void executeTask() {
		System.out.println("Task executed");
	}
	
	@Test
	public void logoutAsAdmin() {
		System.out.println("Logout as Admin");
	}
	
	@Test (invocationCount = 2, dependsOnMethods = "openBrowser")
	public void closeBrowser() {
		System.out.println("Close browser");
	}
}
