package com.Essan_Rad.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Essan_Rad.GenericUtils.JavaUtility;
import com.Essan_Rad.GenericUtils.WebdriverUtility;

public class RestaurantsPage extends WebdriverUtility{


	public RestaurantsPage() {
	}

	public void validateUpdatedMenu(WebDriver driver, String restName, String menuName) {
		WebElement target = driver.findElement(By.linkText(restName));
		scrollDownToElement(driver, target);
		driver.findElement(By.xpath("//a[.='"+restName+"']/ancestor::div[contains(@class,'text-xs-center text-sm-left')]/following-sibling::div[1]//a[.='View Menu']")).click();
		try {
			driver.findElement(By.linkText(menuName));
			Assert.assertTrue(true);
			System.out.println("Updated menu is visible in restaurant");
		} catch (Exception e) {
			Assert.assertTrue(false, "Updated menu is not visible in restaurant");
			System.out.println("Updated menu is not visible in restaurant");
		}
	}
}
