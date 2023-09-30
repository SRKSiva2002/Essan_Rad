package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

	@FindBy (name ="username")
	private WebElement UsernameTextField;
	
	@FindBy (name ="password")
	private WebElement PasswordTextField;
	
	@FindBy (name ="submit")
	private WebElement SubmitButton;
	
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void userLogin(String userName, String passWord) {
		UsernameTextField.sendKeys(userName);
		PasswordTextField.sendKeys(passWord);
		SubmitButton.click();
	}
}
