package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeBeforeLoginPage {

	@FindBy (partialLinkText ="Home")
	private WebElement HomeLink;
	
	@FindBy (partialLinkText ="Restaurants")
	private WebElement RestaurantLink;
	
	@FindBy (linkText ="Login")
	private WebElement LoginLink;
	
	@FindBy (linkText ="Register")
	private WebElement RegisterLink;
	
	public HomeBeforeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickLoginLink() {
		LoginLink.click();
	}
	public void clickRegisterLink() {
		RegisterLink.click();
	}
}
