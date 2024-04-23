package com.alpha.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtils {

	public static WebElement waitTillVisibilityOfElement(WebDriver driver, int i, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		return wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static WebElement waitTillElementToClickable(WebDriver driver, int i, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		return wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	public static void enterValueToField(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

		try {
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with ID 'myElement' not found!");
		} finally {
			// Close the browser or perform other cleanup tasks (optional)
		}
	}

}
