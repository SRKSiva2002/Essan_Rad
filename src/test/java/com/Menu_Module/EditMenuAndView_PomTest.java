package com.Menu_Module;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.ObjectRepo.AddMenuPage;
import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;
import com.Essan_Rad.ObjectRepo.EditMenuPage;
import com.Essan_Rad.ObjectRepo.HomeAfterLoginPage;
import com.Essan_Rad.ObjectRepo.HomeBeforeLoginPage;
import com.Essan_Rad.ObjectRepo.RestaurantsPage;
import com.Essan_Rad.ObjectRepo.UserLoginPage;

public class EditMenuAndView_PomTest extends BaseClass {

	@Test(groups = "regression")
	public void EditMenuAndView() throws Throwable {
		String aurl=fLib.readPropertyFile("admin_url");
		String aUname = fLib.readPropertyFile("admin_username");
		String aPwd = fLib.readPropertyFile("admin_password");
		String uUrl = fLib.readPropertyFile("user_url");
		String uUname = fLib.readPropertyFile("user_username");
		String uPwd = fLib.readPropertyFile("user_password");
		driver.get(aurl);
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(aUname, aPwd);

		AdminPanelPage app = new AdminPanelPage(driver);
		app.clickAddMenu();

		HashMap<String, String> data = eLib.readMultipleDataFromExcel("Menu", 0, 1);
		String menuName = eLib.readDataFromExcelFile("Menu", 2, 4);

		AddMenuPage amp = new AddMenuPage(driver);
		String actualMenu = amp.addMenu(data, driver, jLib, menuName);
		amp.validateAddedMenu(driver);

		app.clickAllMenu();

		HashMap<String, String> editData = eLib.readMultipleDataFromExcel("Edit-Menu", 0, 1);
		EditMenuPage emp = new EditMenuPage(driver);
		emp.clickOnEditMenu(driver, actualMenu);
		String editedMenu = emp.editMenu(editData, driver, jLib, menuName);

		app.clickAllMenu();

		emp.validateEditedMenu(driver, editedMenu);

		app.logoutAsAdmin();

		driver.get(uUrl);

		HomeBeforeLoginPage hblp = new HomeBeforeLoginPage(driver);
		hblp.clickLoginLink();

		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.userLogin(uUname, uPwd);

		String restName = eLib.readDataFromExcelFile("Edit-Menu", 2, 4);
		HomeAfterLoginPage halp = new HomeAfterLoginPage(driver);
		halp.clickRestaurants();

		RestaurantsPage r = new RestaurantsPage();
		r.validateUpdatedMenu(driver, restName, menuName);

	}
}
