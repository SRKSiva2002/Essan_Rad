package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {

	@FindBy (xpath ="//span[.='Dashboard']")
	private WebElement DashboardButton;
	
	@FindBy (xpath ="//span[text()='Users']")
	private WebElement UsersButton;
	
	@FindBy (xpath ="//span[.='Restaurant']")
	private WebElement RestaurantButton;
	
	@FindBy (linkText = "All Restaurant")
	private WebElement AllRestaurantLink;
	
	@FindBy (linkText = "Add Category")
	private WebElement AddCategoryLink;
	
	@FindBy (linkText = "Add Restaurant")
	private WebElement AddRestaurantLink;
	
	@FindBy (xpath = "//span[@class='hide-menu' and .='Menu']")
	private WebElement MenuButton;
	
	@FindBy (linkText = "All Menues")
	private WebElement AllMenuesLink;
	
	@FindBy (linkText = "Add Menu")
	private WebElement AddMenuesLink;
	
	@FindBy (xpath = "//span[.='Orders']")
	private WebElement OrdersButton;
	
	@FindBy (xpath = "//img[@class='profile-pic']")
	private WebElement ProfilePicIcon;
	
	@FindBy (xpath = "//a[contains(text(),'Logout')]")
	private WebElement LogoutButton;
	
	public AdminPanelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getDashboardCount(WebDriver driver, String categoryName) {
		DashboardButton.click();
		String count = driver.findElement(By.xpath("//p[.='"+categoryName+"']/../h2")).getText();
		int value = Integer.parseInt(count);
		System.out.println(value);
		return value;
	}
	
	public void clickAllMenu() throws Throwable {
		Thread.sleep(2000);
		MenuButton.click();
		AllMenuesLink.click();
	}
	
	public void clickAddMenu() {
		MenuButton.click();
		AddMenuesLink.click();
	}
	
	public void clickonOrders() {
		OrdersButton.click();
	}
	
	public void logoutAsAdmin() {
		ProfilePicIcon.click();
		LogoutButton.click();
	}
	
	public void clickAddCategory() {
		RestaurantButton.click();
		AddCategoryLink.click();
	}
	
	public void clickAddRestaurant() {
		AddRestaurantLink.click();
	}
}
