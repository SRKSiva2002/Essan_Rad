package com.Order_Module;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteOrderAdminTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new FirefoxDriver();
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
		Thread.sleep(10);
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame().findElement(By.linkText("Logout")).click();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Orders")).click();
		List<WebElement> details = driver.findElements(By.xpath("//table/tbody/tr[last()]/td"));
		for (WebElement w : details) {
			System.out.println(w.getText());
		}
		driver.findElement(By.xpath("//table/tbody/tr[last()]/td[8]//i[@class='fa fa-trash-o']")).click();
		driver.switchTo().alert().accept();
		String actual=driver.findElement(By.xpath("//table/tbody/tr//center[.='No Orders']")).getText();
		String exp = "No Orders";
		if (actual.contains(exp)) {
			System.out.println("Order is deleted in admin page");
		} else {
			System.out.println("Order is not deleted in admin page");
		}
		driver.quit();
		
	}
}
