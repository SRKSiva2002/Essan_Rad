package com.Order_Module;

import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.ObjectRepo.CheckOutPage;
import com.Essan_Rad.ObjectRepo.DishesPage;
import com.Essan_Rad.ObjectRepo.HomeAfterLoginPage;
import com.Essan_Rad.ObjectRepo.HomeBeforeLoginPage;
import com.Essan_Rad.ObjectRepo.MyOrdersPage;
import com.Essan_Rad.ObjectRepo.UserLoginPage;
public class UserMyOrdersCheckPomTest extends BaseClass {

	@Test(groups = "regression")
	public void UserMyOrdersCheck() throws Throwable {
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
		
		ulp.userLogin(uUname, uPwd);
		
		halp.clickMyOrders();
		
		MyOrdersPage mop=new MyOrdersPage(driver);
		mop.validateOrder(driver, menuName);
	}
}
