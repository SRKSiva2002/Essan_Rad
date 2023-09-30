package com.Essan_Rad.ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Essan_Rad.GenericUtils.WebdriverUtility;

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
