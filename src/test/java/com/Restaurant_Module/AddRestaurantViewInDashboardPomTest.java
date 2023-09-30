package com.Restaurant_Module;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.ObjectRepo.AddCategoryPage;
import com.Essan_Rad.ObjectRepo.AddRestaurantPage;
import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;

public class AddRestaurantViewInDashboardPomTest extends BaseClass{

	@Test(groups = "smoke")
	public void AddRestaurantViewInDashboard() throws Throwable {
		String aurl=fLib.readPropertyFile("admin_url");
		String aUname = fLib.readPropertyFile("admin_username");
		String aPwd = fLib.readPropertyFile("admin_password");
		driver.get(aurl);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.adminLogin(aUname, aPwd);
		
		AdminPanelPage app=new AdminPanelPage(driver);
		int beforeCount=app.getDashboardCount(driver, "Restaurants");
		app.clickAddCategory();
		
		String catName=eLib.readDataFromExcelFile("Category", 1, 1)+jLib.getRandomNumber();
		AddCategoryPage acp = new AddCategoryPage(driver);
		acp.addCategory(catName);
		acp.validateCategory(driver, catName);
		app.clickAddRestaurant();
		
		HashMap<String, String> data = eLib.readMultipleDataFromExcel("Restaurant", 0, 1);
		String openHrs=eLib.readDataFromExcelFile("Restaurant", 1, 3);
		String closeHrs=eLib.readDataFromExcelFile("Restaurant", 2, 3);
		String openDays=eLib.readDataFromExcelFile("Restaurant", 3, 3);
		
		AddRestaurantPage arp= new AddRestaurantPage(driver);
		arp.addRestaurant(data, driver, wLib, jLib, openHrs, closeHrs, openDays, catName);
		
		int afterCount=app.getDashboardCount(driver, "Restaurants");
		
		if (beforeCount<afterCount) {
			Assert.assertTrue(true);
			System.out.println("Restaurant is added");
		} else {
			Assert.assertFalse(false, "Restaurant is not added");
			System.out.println("Restaurant is not added");
		}
	}
}
