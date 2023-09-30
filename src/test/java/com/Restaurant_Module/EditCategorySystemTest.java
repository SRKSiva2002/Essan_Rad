package com.Restaurant_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EditCategorySystemTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		String dish="Chicken Biriyani";
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.linkText("Add Category")).click();
		String oCat="Indo-Chinese"; String nCat="Bhara-Chinese";
		driver.findElement(By.xpath("//td[.='"+oCat+"']/ancestor::tr//i[@class='fa fa-edit']")).click();
		driver.findElement(By.name("c_name")).clear();
		driver.findElement(By.name("c_name")).sendKeys(nCat);
		driver.findElement(By.name("submit")).click();
		String actual=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String expect="Successfully";
		if (actual.contains(expect)) {
			System.out.println("Category is Updated");
		} else {
			System.out.println("Category is not Updated");
		}
		driver.quit();
	}
}
