package com.Menu_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EditMenuAndViewSystemTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		String dish="Chicken Biriyani";
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[@class='hide-menu' and .='Menu']")).click();
		driver.findElement(By.linkText("Add Menu")).click();
		driver.findElement(By.name("d_name")).sendKeys(dish);
		driver.findElement(By.name("about")).sendKeys("Well cooked biriyani with chicken pieces");
		driver.findElement(By.name("price")).sendKeys("20");
		driver.findElement(By.name("file")).sendKeys("D:\\TEST YANTRA\\INDI BISTRO - PROJECT\\IMAGES\\Biriyani.jpg");
		WebElement rest = driver.findElement(By.name("res_name"));
		Select s = new Select(rest);
		s.selectByVisibleText("@@@@");
		driver.findElement(By.name("submit")).click();
		String aMenu=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String eMenu="New Dish Added";
		if (aMenu.contains(eMenu)) {
			System.out.println("New Menu is added to Restaurant");
		}
		else {
			System.out.println("New Menu is not added to Restaurant");
		}
		driver.findElement(By.linkText("All Menues")).click();
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[*]/a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		String reDish="Mutton biriyani";
		driver.findElement(By.name("d_name")).clear();
		driver.findElement(By.name("d_name")).sendKeys(reDish);
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("30");
		driver.findElement(By.name("file")).sendKeys("D:\\TEST YANTRA\\INDI BISTRO - PROJECT\\IMAGES\\Biriyani.jpg");
		WebElement rest1 = driver.findElement(By.name("res_name"));
		Select s1 = new Select(rest1);
		s1.selectByVisibleText("@@@@");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		String actual=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String expect="Updated";
		if (actual.contains(expect)) {
			System.out.println("Menu is Updated");
		}
		else {
			System.out.println("Menu is not deleted");
		}
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("ABCD");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.partialLinkText("Restaurants")).click();
		WebElement tRest = driver.findElement(By.linkText("@@@@"));
		a.scrollToElement(tRest).perform();
		driver.findElement(By.xpath("//a[.='@@@@']/ancestor::div[contains(@class,'text-xs-center text-sm-left')]/following-sibling::div[1]//a[.='View Menu']")).click();
		String uMenu=driver.findElement(By.xpath("//h6[.='Mutton biriyani']")).getText();
		if (uMenu.equals(reDish)) {
			System.out.println("Menu is updated and getting visible in user page");
		} else {
			System.out.println("Menu is updated but not visible in user page");
		}
		driver.quit();
	}
}
