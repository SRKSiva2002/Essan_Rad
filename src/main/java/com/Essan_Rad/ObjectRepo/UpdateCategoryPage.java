package com.Essan_Rad.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateCategoryPage {

	@FindBy (name  ="c_name")
	private WebElement CategoryTextField;
	
	@FindBy (name  ="submit")
	private WebElement SaveButton;
	
	@FindBy (linkText = "Cancel")
	private WebElement CancelButton;
	
	public UpdateCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
