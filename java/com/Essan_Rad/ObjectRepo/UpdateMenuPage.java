package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateMenuPage {

	@FindBy (name  ="d_name")
	private WebElement DishNameTextField;
	
	@FindBy (name  ="about")
	private WebElement DescriptionTextField;
	
	@FindBy (name  ="price")
	private WebElement PriceTextField;
	
	@FindBy (name  ="file")
	private WebElement ChooseFileButton;
	
	@FindBy (name  ="res_name")
	private WebElement RestaurantDropDown;
	
	@FindBy (name  ="submit")
	private WebElement SaveButton;
	
	@FindBy (linkText = "Cancel")
	private WebElement CancelButton;
	
	public UpdateMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
