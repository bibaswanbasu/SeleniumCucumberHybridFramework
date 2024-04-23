package com.alpha.test.common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.alpha.utils.captureScreenshot;

public class Listeners extends captureScreenshot implements ITestListener  {

	WebDriver driver;

	public Listeners(WebDriver driver) {
		super(driver);
	}

//	captureScreenshot captureSS = new captureScreenshot(driver);

	public void onTestFailure(ITestResult result) {
		System.out.println("listing........................");
		takeScreenshotAs(driver, result.getTestName());

	}


}
