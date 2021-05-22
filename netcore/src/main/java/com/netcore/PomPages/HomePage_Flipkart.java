package com.netcore.PomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Flipkart {
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement LoginBtn;
	
	@FindBy(name="q")
	private WebElement searchbox;
	
	@FindBy(xpath="//span[contains(text(),'Showing 1 – 24 ')]")
	private WebElement contentValue;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> Iphonedevices;
	
	@FindBy(xpath="//span[contains(text(),'Ratings')]")
	private List<WebElement> Ratings;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> Price;
	
	
   public HomePage_Flipkart(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}


public WebElement getLoginBtn() {
	return LoginBtn;
}


public WebElement getSearchbox() {
	return searchbox;
}


public WebElement getContentValue() {
	return contentValue;
}


public List<WebElement> getIphonedevices() {
	return Iphonedevices;
}


public List<WebElement> getRatings() {
	return Ratings;
}


public List<WebElement> getPrice() {
	return Price;
}
	
	
}
