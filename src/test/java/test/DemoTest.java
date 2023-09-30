package test;


import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;

public class DemoTest extends BaseClass {

	@Test(groups = {"smoke", "regression"}, retryAnalyzer = com.Essan_Rad.GenericUtils.RetryImplementationClass.class)
	public void demo3() {
		System.out.println("---DEMO 3---");
	}
	
	@Test(groups = "smoke")
	public void demo1() {
		System.out.println("---DEMO 1---");
	}
	
	@Test(groups = "regression")
	public void demo2() {
		System.out.println("---DEMO 2---");
	}
}
