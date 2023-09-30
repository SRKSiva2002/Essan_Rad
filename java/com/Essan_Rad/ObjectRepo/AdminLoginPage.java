package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	@FindBy (name="username")
	private WebElement UsernameTextField;
	
	@FindBy (name="password")
	private WebElement PasswordTextField;
	
	@FindBy (name="submit")
	private WebElement SubmitButton;
	
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void adminLogin(String userName, String passWord) {
		UsernameTextField.sendKeys(userName);
		PasswordTextField.sendKeys(passWord);
		SubmitButton.click();
	}
}
