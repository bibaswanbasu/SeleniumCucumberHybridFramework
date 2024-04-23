package com.sel.prac;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	@Test
	public void handleWindows() {
		String parentWindowTitle;
		String childWindowTitle;

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();

		parentWindowTitle = driver.getTitle();

		// STORE THE CURRENT WINDOW HANDLE USING getWindowHanle() METHOD
		String parentWindow = driver.getWindowHandle();

		WebElement openWindowBtn = driver.findElement(By.id("openwindow"));
		openWindowBtn.click();

		// USING getWindowHandles() METHOD STORE ALL THE WINDOWID IN A OBJECT, WHICH IS
		// SET OF STRING
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String window : allWindowHandles) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		childWindowTitle = driver.getTitle();
		if (!parentWindowTitle.equals(childWindowTitle)) {
			System.out.println("Test Case Passed!");
			System.out.println("Parent Window Title- " + parentWindowTitle);
			System.out.println("Child Window Title- " + childWindowTitle);
		} else {
			System.out.println("Test Case Failed");
		}

		driver.close();

		driver.switchTo().window(parentWindow);

	}

}
