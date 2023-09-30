package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;

public class SampleTest extends BaseClass  {

	@Test(groups = {"smoke", "regression"})
	public void sample2() {
		System.out.println("---SAMPLE 2---");
	}
	
	@Test(groups = "smoke")
	public void sample3() {
		Assert.fail();
		System.out.println("---SAMPLE 3---");
	}
	
	@Test(groups = "regression")
	public void sample1() {
		System.out.println("---SAMPLE 1---");
	}
}
