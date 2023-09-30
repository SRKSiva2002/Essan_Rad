package com.Essan_Rad.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of methods to handle webdriver and webelements
 * @author Sivabalan Selvaraj
 *
 */
public class WebdriverUtility {

	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public void closeTheBrowser(WebDriver driver) {
		driver.close();
	}
	/**
	 * This method is used to close the browser including all the windows
	 * @param driver
	 */
	public void closeAllTheWindows(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method is used to wait until elements to be finded
	 * @param driver
	 * @param duration
	 */
	public void implicitWaitByFindElement(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method is used to wait until page to be loaded
	 * @param driver
	 * @param duration
	 */
	public void impicitWaitUntilPageload(WebDriver driver, int duration) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(duration));
	}
	/**
	 * This method is used to wait until url of the page gets load
	 * @param driver
	 * @param duration
	 * @param url
	 */
	public void waitUntilUrl(WebDriver driver, int duration, String url) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * This method is used to wait until title of the page gets load
	 * @param driver
	 * @param duration
	 * @param title
	 */
	public void waitUntilPageTitle(WebDriver driver, int duration, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method is used to wait until element of the page to be enabled
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to wait until element of page to be visible
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeVisible(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used wait until alert to be present
	 * @param driver
	 * @param duration
	 */
	public void waitUntilAlert(WebDriver driver, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method is used to ignore the no such element exception of page
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method is used to customize wait for 20 seconds till element to be clickable
	 * @param element
	 * @throws Throwable 
	 */
	public void customWait(WebElement element) throws Throwable {
		int count=0;
		while (count<20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method is used to move the mouse pointer to particular element of page
	 * @param driver
	 * @param element
	 */
	public void mouseOverToElement(WebDriver driver, WebElement element ) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform drag and drop action
	 * @param driver
	 * @param target
	 * @param source
	 */
	public void dragAndDropAction(WebDriver driver,WebElement target, WebElement source) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	/**
	 * This method is used to right click on particular element of page
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to double click on particular element of page
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method is used to press enter key
	 * @param driver
	 */
	public void clickOnEnterKey (WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to press enter key using robot class
	 * @param driver
	 */
	public void pressEnterKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release enter key using robot class
	 * @param driver
	 */
	public void releaseEnterKey() throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to scroll down mouse pointer to particular element
	 * @param driver
	 * @param element
	 */
	public void scrollDownToElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.scrollToElement(element);
	}
	/**
	 * This method is used to scroll down mouse pointer to particular value
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollDownByAmount(WebDriver driver, int x, int y) {
		Actions a = new Actions(driver);
		a.scrollByAmount(x, y);
	}
	/**
	 * This method is used to select the drop down based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select drop down based on value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select drop down based on visible text
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text,WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to switch to frame based on id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, int id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch to frame based on address
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, String address) {
		driver.switchTo().frame(address);
	}
	/**
	 * This method is used to switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to switch to parent frame of current frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to accept the alert popup of page
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	/**
	 * This method is used to decline the alert popup of page
	 * @param driver
	 */
	public void rejectAlertPopup(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * This method is used to switch to window based on title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchToWindow(WebDriver driver, String expectedTitle) {
		Set<String> wh = driver.getWindowHandles();
		for (String str : wh) {
			driver.switchTo().window(str);
			String title=driver.getTitle();
			if (title.contains(expectedTitle)) {
				break;
			}
		}
	}
	/**
	 * This method is used to switch to window based on url
	 * @param expectedUrl
	 * @param driver
	 */
	public void switchToWindow(String expectedUrl, WebDriver driver) {
		Set<String> wh = driver.getWindowHandles();
		for (String str : wh) {
			driver.switchTo().window(str);
			String title=driver.getCurrentUrl();
			if (title.contains(expectedUrl)) {
				break;
			}
		}
	}
	/**
	 * This method is used to take screen shot and save it in file
	 * @param driver
	 * @param name
	 * @param path
	 * @return 
	 */
	public static String takeScreenShot(WebDriver driver, String screenShotName) {
		String date = JavaUtility.getSystemDateinFormat2();
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./ScreenShot/"+screenShotName+date+".png";
		File des = new File(path);
		try {
			FileUtils.copyFile(src, des);
			System.out.println("Screen Shot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	/**
	 * This method is used to scroll down mouse pointer to particular element using java script
	 * @param driver
	 * @param element
	 */
	public void scrollDownToElementJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * This method is used to scroll down by some amount of pixel
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollDownByAmountJs(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")", "");
	}
	
}
