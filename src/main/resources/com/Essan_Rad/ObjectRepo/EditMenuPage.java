package com.Essan_Rad.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Essan_Rad.GenericUtils.JavaUtility;
import com.Essan_Rad.GenericUtils.WebdriverUtility;

public class EditMenuPage extends WebdriverUtility{
	
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
	
	public EditMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnEditMenu(WebDriver driver,String restName) {
		driver.findElement(By.xpath("//td[.='"+restName+"']/ancestor::tr//i[@class='fa fa-edit']")).click();
	}
	
	public String editMenu(HashMap<String, String> map, WebDriver driver,JavaUtility lib,String restName) {
		String nameRandom = null;
		DishNameTextField.clear();
		PriceTextField.clear();
		for (Entry<String, String> s : map.entrySet()) {
			if (s.getKey().contains("d_name")) {
				nameRandom=s.getValue()+lib.getRandomNumber();
				driver.findElement(By.name(s.getKey())).sendKeys(nameRandom);
			} else {
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}
		selectDropDown(restName, RestaurantDropDown);
		SaveButton.click();
		return nameRandom;
	}
	
	public void validateEditedMenu(WebDriver driver, String restName) {
		String actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		if (actual.equalsIgnoreCase(restName)) {
			System.out.println("Menu is updated");
		}
		else {
			System.out.println("Menu is not updated");
		}
	}
}
