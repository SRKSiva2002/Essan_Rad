package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeAfterLoginPage {

	@FindBy (partialLinkText ="Home")
	private WebElement HomeLink;
	
	@FindBy (partialLinkText ="Restaurants")
	private WebElement RestaurantLink;
	
	@FindBy (linkText ="My Orders")
	private WebElement MyOrdersLink;
	
	@FindBy (linkText ="Logout")
	private WebElement LogoutLink;
	
	public HomeAfterLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickRestaurants() {
		RestaurantLink.click();
	}
	public void logoutAsUser() {
		LogoutLink.click();
	}
	public void clickMyOrders() {
		MyOrdersLink.click();
	}
}
