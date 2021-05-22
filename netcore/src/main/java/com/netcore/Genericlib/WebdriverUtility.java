package com.netcore.Genericlib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	/**
	 * used to select the visibletext from the dropDown based on visibletext
	 * @param element
	 * @param visibletext
	 */
	public void selectdd(WebElement element , String visibletext) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletext);
	}
	
	/**
	 *  used to select the value from the dropDwon based on index
	 * @param element
	 * @param index
	 */
	public void selectdd(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * switch to any window based on Window title
	 * @param windowPartialTitle
	 */
	public void switchToWindow(WebDriver driver ,String window) {
		 //switchTo new Window
		  Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			if(driver.getCurrentUrl().contains(window)) {
				break;
			}
		 }
	}
	/**
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public void waitForPageTitle(WebDriver driver , String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementClickable(WebDriver driver , WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
/**
 *   wait for elemnet to be avibale
 * @param driver
 * @param eleXpath
 * @throws InterruptedException
 */
	public void waitForElementXpath(WebDriver driver , String eleXpath) throws InterruptedException {
		int count =0 ; 
		 while(count<40) {
			 try {
				 driver.findElement(By.xpath(eleXpath)).isEnabled();
				 break;
			 }
			 catch (Exception e) {
				Thread.sleep(500);
				count ++;
			}
		 }
	}	
	
	/**
	 * used to perfrom mouse movement action on the elemnet
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver , WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * used to perfrom rightClcik movement action on the elemnet
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver , WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
}
