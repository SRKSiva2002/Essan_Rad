package com.Restaurant_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddRestaurantViewInDashboardTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		String pCount = driver.findElement(By.xpath("//p[.='Restaurants']/../h2")).getText();
		int pValue = Integer.parseInt(pCount);
		System.out.println(pValue);
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.linkText("Add Category")).click();
		driver.findElement(By.name("c_name")).sendKeys("Indo-Chinese");
		driver.findElement(By.name("submit")).click();
		String expect="Added Successfully";
		String aCat=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		if (aCat.contains(expect)) {
			System.out.println("Category added");
		} else {
			System.out.println("Category is not added");
		}
		driver.findElement(By.linkText("Add Restaurant")).click();
		driver.findElement(By.name("res_name")).sendKeys("Biriyani Depot");
		driver.findElement(By.name("email")).sendKeys("biriyanidepot@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		driver.findElement(By.name("url")).sendKeys("www.biriyanidepot.com");
		WebElement ohr = driver.findElement(By.name("o_hr"));
		Select s1= new Select(ohr);
		s1.selectByVisibleText("10am");
		WebElement chr = driver.findElement(By.name("c_hr"));
		Select s2=new Select(chr);
		s2.selectByVisibleText("11pm");
		WebElement oday = driver.findElement(By.name("o_days"));
		Select s3= new Select(oday);
		s3.selectByVisibleText("Mon-Sat");
		driver.findElement(By.name("file")).sendKeys("D:\\TEST YANTRA\\INDI BISTRO - PROJECT\\IMAGES\\Biriyani Depot.jpg");
		WebElement cat = driver.findElement(By.name("c_name"));
		Select s4=new Select(cat);
		s4.selectByVisibleText("Indo-Chinese");
		driver.findElement(By.name("address")).sendKeys("Bengaluru-560019, Karnataka");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Dashboard']")).click();
		String aCount = driver.findElement(By.xpath("//p[.='Restaurants']/../h2")).getText();
		int aValue = Integer.parseInt(aCount);
		System.out.println(aValue);
		if (pValue<aValue) {
			System.out.println("Restaurant is added");
		} else {
			System.out.println("Restaurant is not added");
		}
		driver.quit();              
	}
}
