package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Essan_Rad.GenericUtils.WebdriverUtility;

public class AllOrdersPage {
	
	public AllOrdersPage(){
		
	}

	public String clickOnDeleteOrder(WebDriver driver,String menuName, WebdriverUtility lib) {
		String date=driver.findElement(By.xpath("//tr[last()]/td[7]")).getText();
		driver.findElement(By.xpath("//tr[last()]/td[.='"+menuName+"']/ancestor::tr//i[@class='fa fa-trash-o']")).click();
		lib.acceptAlertPopup(driver);
		return date;
	}

	public void validateDeletedOrder(WebDriver driver, String date) {
	try {
		driver.findElement(By.xpath("//td[.='"+date+"']"));
		Assert.assertFalse(true);
		System.out.println("Order is not deleted");
	} catch (Exception e) {
		Assert.assertFalse(false, "Order is deleted");
		System.out.println("Order is deleted");
	}
	}
}
