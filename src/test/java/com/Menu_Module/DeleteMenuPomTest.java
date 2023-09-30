
package com.Menu_Module;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.ObjectRepo.AddMenuPage;
import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;
import com.Essan_Rad.ObjectRepo.DeleteMenuPage;

public class DeleteMenuPomTest extends BaseClass {

	@Test(groups = "smoke")
	public void DeleteMenu() throws Throwable {
		String url=fLib.readPropertyFile("admin_url");
		String aUname = fLib.readPropertyFile("admin_username");
		String aPwd = fLib.readPropertyFile("admin_password");
		driver.get(url);
		HashMap<String, String> data = eLib.readMultipleDataFromExcel("Menu", 0, 1);
		String restName = eLib.readDataFromExcelFile("Menu", 2, 4);

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(aUname, aPwd);

		AdminPanelPage app = new AdminPanelPage(driver);
		app.clickAddMenu();

		AddMenuPage amp = new AddMenuPage(driver);
		String actualResName = amp.addMenu(data, driver, jLib, restName);
		amp.validateAddedMenu(driver);
		app.clickAllMenu();

		DeleteMenuPage dmp = new DeleteMenuPage();
		dmp.clickOnDeleteMenu(driver, actualResName);
		dmp.validateDeletedMenu(driver, restName);
	}
}
