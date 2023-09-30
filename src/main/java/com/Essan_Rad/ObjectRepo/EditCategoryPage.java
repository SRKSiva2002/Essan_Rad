package com.Essan_Rad.ObjectRepo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditCategoryPage {

	@FindBy (name  ="c_name")
	private WebElement CategoryTextField;
	
	@FindBy (name  ="submit")
	private WebElement SaveButton;
	
	@FindBy (linkText = "Cancel")
	private WebElement CancelButton;
	
	public EditCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void editCategory(String categoryName) {
		CategoryTextField.clear();
		CategoryTextField.sendKeys(categoryName);
		SaveButton.click();
	}
	public void validateCategory(WebDriver driver, String catName) {
		try {
			driver.findElement(By.xpath("//tr[*]/td[.='"+catName+"']"));
			Assert.assertTrue(true);
			System.out.println("Category is updated");
		} catch (Exception e) {
			Assert.assertTrue(false,"Category is not updated");
			System.out.println("Category is not updated");
		}
	}
}
