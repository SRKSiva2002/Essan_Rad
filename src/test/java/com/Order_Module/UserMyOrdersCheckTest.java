package com.Order_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UserMyOrdersCheckTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("ABCD");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.partialLinkText("Restaurants")).click();
		WebElement rest = driver.findElement(By.linkText("@@@@"));
		a.scrollToElement(rest).perform();
		driver.findElement(By.xpath("//a[.='@@@@']/ancestor::div[contains(@class,'text-xs-center text-sm-left')]/following-sibling::div[1]//a[.='View Menu']")).click();
		driver.findElement(By.xpath("//input[@class='btn theme-btn']")).click();
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame().findElement(By.linkText("Logout")).click();
		driver.findElement(By.name("username")).sendKeys("ABCD");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("My Orders")).click();
		String aOrder=driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText();
		String order="Mutton biriyani";
		if (aOrder.contains(order)) {
			System.out.println("Order is visible in Myorders page");
		} else {
			System.out.println("Order is not visible in Myorders page");
		}
		driver.quit();
	}
}
