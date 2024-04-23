package com.sel.prac;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import de.erichseifert.vectorgraphics2d.Document;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenInNewTabAndValidate {

	public static void main(String[] args) {

		openNewTab1();
//		inputWithoutSendKeys();
//		brokenLinkFinder();


	}

	public static void openNewTab() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		List<WebElement> footerLinks = driver.findElements(By.xpath("(//ul)[1]//li[@class='gf-li']/a"));
		String paretnWindow = driver.getWindowHandle();

		Map<List<String>, List<String>> mapList = new HashMap<>();

		List<String> footerName = new ArrayList<>();
		List<String> footerNameTitle = new ArrayList<>();

		for (int i = 0; i < footerLinks.size(); i++) {

			String newTabKey = Keys.chord(Keys.CONTROL, Keys.ENTER);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", footerLinks.get(i));
			footerName.add(footerLinks.get(i).getText());

			footerLinks.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Set<String> allWindow = driver.getWindowHandles();

			for (String handle : allWindow) {
				if (!handle.equals(paretnWindow)) {
					driver.switchTo().window(handle);
					break;
				}
			}

			footerNameTitle.add(driver.getTitle());

			driver.close();

			driver.switchTo().window(paretnWindow);

		}

		mapList.put(footerName, footerNameTitle);

		System.out.println(footerName);
		System.out.println(footerNameTitle);

		driver.quit();
	}

	public static void openNewTab1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		List<WebElement> footerLinks = driver.findElements(By.xpath("(//ul)[1]//li[@class='gf-li']/a"));
		String paretnWindow = driver.getWindowHandle();

		Map<List<String>, List<String>> mapList = new HashMap<>();

		List<String> footerName = new ArrayList<>();
		List<String> footerNameTitle = new ArrayList<>();

		for (int i = 0; i < footerLinks.size(); i++) {

			String newTabKey = Keys.chord(Keys.CONTROL, Keys.ENTER);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", footerLinks.get(i));
			footerName.add(footerLinks.get(i).getText());

			footerLinks.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Set<String> allWindow = driver.getWindowHandles();

		for (String handle : allWindow) {
			if (!handle.equals(paretnWindow)) {
				driver.switchTo().window(handle);

				footerNameTitle.add(driver.getTitle());
				mapList.put(footerName, footerNameTitle);

				driver.close();

			}
		}

		driver.switchTo().window(paretnWindow);

		System.out.println(footerName);
		System.out.println(footerNameTitle);

		driver.quit();
	}

	public static void inputWithoutSendKeys() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		WebElement inputSelectCountries = driver
				.findElement(By.cssSelector("[placeholder='Type to Select Countries']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value = arguments[1];", inputSelectCountries, "India");
//		js.executeScript("document.querySelector('[placeholder=\"Type to Select Countries\"]').value='India'");

	}

	public static void brokenLinkFinder() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterate through each link and check for broken links
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLink(url);
		}

		// Close the browser
		driver.quit();
	}

	private static void verifyLink(String url) {
		try {
			// Create a URL object
			URL linkUrl = new URL(url);

			// Open a connection to the URL
			HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();

			// Get the HTTP response code
			int responseCode = httpURLConnection.getResponseCode();

			// Check for broken links (response code 404 or 400 indicates a broken link)
			if (responseCode >= 400) {
				System.out.println("Broken Link: " + url + " - Response Code: " + responseCode);
			} else {
				System.out.println("Valid Link: " + url + " - Response Code: " + responseCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
