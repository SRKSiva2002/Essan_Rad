package com.Essan_Rad.ObjectRepo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MyOrdersPage {

	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateOrder(WebDriver driver, String menuName) {
		String orderName=driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText();
		if (orderName.contains(menuName)) {
			Assert.assertTrue(true);
			System.out.println("Order is visible in Myorders page");
		} else {
			Assert.assertTrue(false,"Order is not visible in Myorders page");
			System.out.println("Order is not visible in Myorders page");
		}
	}
}
