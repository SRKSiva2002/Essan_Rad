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

public class AddMenuPage extends WebdriverUtility {

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
	
	public AddMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String addMenu(HashMap<String, String> map, WebDriver driver,JavaUtility lib,String restName) {
		String nameRandom = null;
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
	public void validateAddedMenu(WebDriver driver) {
		String confirmMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String expectedMsg="New Dish Added";
		if (confirmMsg.contains(expectedMsg)) {
			System.out.println("New Menu is added to Restaurant");
		}
		else {
			System.out.println("New Menu is not added to Restaurant");
		}
	}
}
