package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Essan_Rad.GenericUtils.WebdriverUtility;

public class DishesPage extends WebdriverUtility{
	
	@FindBy (linkText ="Checkout")
	private WebElement CheckoutButton;
	
	public DishesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void orderDish(WebDriver driver, String restName, String menuName) {
		WebElement rest = driver.findElement(By.linkText(restName));
		scrollDownToElement(driver, rest);
		driver.findElement(By.xpath("//a[.='"+restName+"']/ancestor::div[contains(@class,'text-xs-center text-sm-left')]/following-sibling::div[1]//a[.='View Menu']")).click();
		driver.findElement(By.xpath("//a[.='"+menuName+"']/ancestor::div[@class='food-item']//input[@class='btn theme-btn']")).click();
		CheckoutButton.click();
	}
}
