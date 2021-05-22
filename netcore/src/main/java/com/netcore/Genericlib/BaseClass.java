package com.netcore.Genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public FileUtility fu = new FileUtility();
	public static WebDriver driver;
		
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		//System.setProperty(key,value)
		//driver=new ChromeDriver();

		String browsername=fu.getPropertyKeyValue("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
					
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();

		}
//		@BeforeClass()
//		public void configBeforeClass() throws Throwable {
//			/*Common  Data*/
//			String URL  = fu.getPropertyKeyValue("url");
//
//			String BROWSER  = fu.getPropertyKeyValue("browser");
//
//			 if(BROWSER.equals("chrome")) {
//			    driver = new ChromeDriver();
//			 }else if(BROWSER.equals("firefox")) {
//				 driver = new FirefoxDriver();
//			 }else if(BROWSER.equals("ie")) {
//				 driver = new InternetExplorerDriver();
//			 }else {
//				 driver = new ChromeDriver(); 
//			 }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(fu.getPropertyKeyValue("url"));
	
}
}
