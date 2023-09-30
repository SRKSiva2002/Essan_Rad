package test;


import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;

public class ExampleTest extends BaseClass  {

	@Test(groups = {"smoke", "regression"})
	public void example1() {
		System.out.println("---EXAMPLE 1---");
	}
	
	@Test(groups = "smoke", invocationCount = -1)
	public void example2() {
		System.out.println("---EXAMPLE 2---");
	}
	
	@Test(groups = "regression", dependsOnMethods = "example2")
	public void example3() {
		System.out.println("---EXAMPLE 3---");
	}
}
