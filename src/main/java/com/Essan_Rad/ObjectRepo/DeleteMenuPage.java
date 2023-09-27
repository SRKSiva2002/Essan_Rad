package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteMenuPage {
	
	public DeleteMenuPage(){
		
	}

	public void clickOnDeleteMenu(WebDriver driver,String restName) {
		driver.findElement(By.xpath("//td[.='"+restName+"']/ancestor::tr//i[@class='fa fa-trash-o']")).click();
	}

	public void validateDeletedMenu(WebDriver driver, String restName) {
		String actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		if (actual.equalsIgnoreCase(restName)) {
			Assert.assertNotSame(actual, restName, "Menu is not deleted");
			System.out.println("Menu is not deleted");
		}
		else {
			Assert.assertNotSame(actual, restName, "Menu is deleted");
			System.out.println("Menu is deleted");
		}
	}
}
