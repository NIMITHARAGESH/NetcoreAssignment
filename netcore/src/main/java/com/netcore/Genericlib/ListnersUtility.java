package com.netcore.Genericlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersUtility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

        String failedTC = result.getMethod().getMethodName();
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = eventDriver.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./screenShot/"+failedTC+".png");
		
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} 
		catch (IOException e) {

		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
