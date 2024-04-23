package com.sel.prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion {

	public static void main(String[] args) {
		handleAutoSugg("India");

	}

	public static void handleAutoSugg(String text) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String strText = null;

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Relative locators
		
		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));

		if (text.length() >= 3) {
			// Use substring to get the first three characters
			strText = text.substring(0, 3);
		} else {
			// If the input string is less than three characters, return the entire string
			strText = text;
		}

		ele.sendKeys(strText);

		String suggetionDrop = "//li[@class='ui-menu-item']//*[text()='" + text + "']";
		WebElement suggetionDropMenu = driver.findElement(By.xpath(suggetionDrop));
		
		wait.until(ExpectedConditions.elementToBeClickable(suggetionDropMenu));
		suggetionDropMenu.click();

	}

}
