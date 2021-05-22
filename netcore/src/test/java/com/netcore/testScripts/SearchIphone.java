package com.netcore.testScripts;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netcore.Genericlib.BaseClass;
import com.netcore.PomPages.HomePage_Flipkart;
import com.opencsv.CSVWriter;

public class SearchIphone extends BaseClass{

	@Test
	public void Searchiphonetestcase() throws Throwable
	{
		
		HomePage_Flipkart hp=new HomePage_Flipkart(driver);
		hp.getLoginBtn().click();
		hp.getSearchbox().sendKeys("iphones less than 40000",Keys.ENTER);
		WebElement searchResult = hp.getContentValue();
		Assert.assertEquals(searchResult.isDisplayed(), true);
		List<WebElement> devlist = hp.getIphonedevices();
		List<WebElement> pricelist = hp.getPrice();
		List<WebElement> ratingslist = hp.getRatings();
		
	
		
		String[] header = {"Device Details", "Price", "Ratings"};
		List<String[]> list = new ArrayList<>();
		list.add(0,header);
		for(int i=0;i<devlist.size();i++)
		{
			String[] row1 = {devlist.get(i).getText(),pricelist.get(i).getText().substring(1),ratingslist.get(i).getText()};
			list.add(i, row1);
		}
		CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/IphonedetailList.csv"));
		writecsv.writeAll(list);
		writecsv.close();
	}
	
}
