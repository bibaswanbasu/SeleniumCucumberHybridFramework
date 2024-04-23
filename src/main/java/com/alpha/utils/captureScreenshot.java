package com.alpha.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class captureScreenshot {

	WebDriver driver;

	public captureScreenshot(WebDriver driver) {
		this.driver = driver;

	}

	public static void takeScreenshotAs(WebDriver driver, String filename) {

		Date newDate = new Date();
		String timeStamp = newDate.toString().replace(" ", "-").replace(":", "-");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destinationFile = new File("./screenshots/" + filename + "_" + timeStamp + ".png");

		try {

			Files.copy(screenshotFile, destinationFile);
			System.out.println("Screenshot taken at Folder - " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("!!! Failed To Take Screenshot - " + e.getMessage());
		}

	}

	public static byte[] takeScreenshot(WebDriver driver) {

		Date newDate = new Date();
		String timeStamp = newDate.toString().replace(" ", "-").replace(":", "-");

		final byte[] screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

//		File destinationFile = new File("./screenshots/" + filename + "_" + timeStamp + ".png");

		return screenshotFile;

	}

	public static void createFolder(String folderPath) {
		File directory = new File(folderPath);
		if (!directory.exists()) {
			directory.mkdirs();
			System.out.println("Successfully created folder: " + folderPath);
		} else {
			System.out.println("Folder already exists: " + folderPath);
		}
	}
}
