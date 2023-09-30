package com.Order_Module;


import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;
import com.Essan_Rad.ObjectRepo.AllOrdersPage;
import com.Essan_Rad.ObjectRepo.CheckOutPage;
import com.Essan_Rad.ObjectRepo.DishesPage;
import com.Essan_Rad.ObjectRepo.HomeAfterLoginPage;
import com.Essan_Rad.ObjectRepo.HomeBeforeLoginPage;
import com.Essan_Rad.ObjectRepo.UserLoginPage;

public class DeleteOrderAdminPomTest extends BaseClass{
	
	@Test(groups ="regression")
	public void DeleteOrderAdmin() throws Throwable {
		
		String aUrl = fLib.readPropertyFile("admin_url");
		String aUname = fLib.readPropertyFile("admin_username");
		String aPwd = fLib.readPropertyFile("admin_password");
		String uUrl=fLib.readPropertyFile("user_url");
		String uUname = fLib.readPropertyFile("user_username");
		String uPwd = fLib.readPropertyFile("user_password");
		
		driver.get(uUrl);
		HomeBeforeLoginPage hblp=new HomeBeforeLoginPage(driver);
		hblp.clickLoginLink();

		UserLoginPage ulp=new UserLoginPage(driver);
		ulp.userLogin(uUname, uPwd);
		
		HomeAfterLoginPage halp= new HomeAfterLoginPage(driver);
		halp.clickRestaurants();
		
		String restName = eLib.readDataFromExcelFile("Edit-Menu", 2, 4);
		String menuName=eLib.readDataFromExcelFile("Order", 1, 1);
		
		DishesPage dp=new DishesPage(driver);
		dp.orderDish(driver, restName, menuName);
		
		CheckOutPage cop=new CheckOutPage(driver);
		cop.clickOrderNowButton(driver);
		
		halp.logoutAsUser();
		
		driver.get(aUrl);
		
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.adminLogin(aUname, aPwd);
		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.clickonOrders();
		
		AllOrdersPage aop=new AllOrdersPage();
		String date=aop.clickOnDeleteOrder(driver, menuName, wLib);
		aop.validateDeletedOrder(driver, date);
	}
}
