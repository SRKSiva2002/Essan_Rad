package com.Essan_Rad.ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Essan_Rad.GenericUtils.WebdriverUtility;

public class CheckOutPage extends WebdriverUtility {

	@FindBy (name ="submit")
	private WebElement OrderNowButton;
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrderNowButton(WebDriver driver) {
		OrderNowButton.click();
		acceptAlertPopup(driver);
		waitUntilAlert(driver, 10);
		acceptAlertPopup(driver);
		switchToMainFrame(driver);
	}
}
