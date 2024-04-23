package com.sel.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YoutubePrac {
	static String videoName = "EP02 Varanasi Ganga Aarti | বেনারসে গঙ্গা আরতি | Assi Ghat | Dashaswamedh Ghat";

	public static void main(String[] args) {
		listOfList();

	}

	@Test
	public static void listOfList() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

		WebDriver driver = new ChromeDriver(chromeOptions);

		try {
			// Open YouTube
			driver.get("https://www.youtube.com");

			Thread.sleep(10);

			// Find the search input field and enter the video title
			WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
			searchBox.sendKeys(videoName);

			// Submit the search form
			searchBox.submit();

			WebElement videoLink = driver.findElement(By.xpath("//a[@title='" + videoName + "']"));
			videoLink.click();

			System.out.println("Clicked");

			// Watch the video until the end (this might need adjustments depending on
			// YouTube's UI changes)
			// For simplicity, we'll just sleep for a fixed time (you may need to adjust
			// this time based on video length)
			Thread.sleep(60000); // Sleep for 60 seconds (assuming the video is at least 1 minute)

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}

}
