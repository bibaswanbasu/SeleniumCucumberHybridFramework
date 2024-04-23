package com.sel.prac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment {
	public static void main(String[] args) {
//		hanldeWebTable();
//		listOfList();
		listOfListPart2("Roland Mendel");

	}

	public static void listOfList() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		List<WebElement> rows = driver.findElements(By.xpath("//h3[text()='Example']//following-sibling::div//tr"));

		System.out.println("Total Rows " + rows.size());

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "\t");

			}
			System.out.println();

		}

		driver.quit();

	}

	public static void listOfListPart2(String cellValue) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		List<WebElement> rows = driver.findElements(By.xpath("//h3[text()='Example']//following-sibling::div//tr"));

		System.out.println("Total Rows " + rows.size());

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < cells.size(); j++) {

				String cValue = cells.get(j).getText();
				if (cValue.equalsIgnoreCase(cellValue)) {
					System.out.println(cellValue + "Present in Column > " + (j+1) + " and Row -> " + i);
					break;
				}

			}
//			System.out.println();

		}

		driver.quit();

	}

	public static void hanldeWebTable() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement table = driver.findElement(By.xpath("//table[@class='table-display']"));
		wait.until(ExpectedConditions.visibilityOf(table));

		// To Get particular row using number we can do
		WebElement secondRow = table.findElements(By.tagName("tr")).get(2);

		// get particular rows column data
		List<WebElement> secondRowColumnData = secondRow.findElements(By.tagName("td"));

		List<WebElement> totalRow = table.findElements(By.tagName("tr"));

		for (WebElement row : totalRow) {
			System.out.println();
			List<WebElement> columnDatas = row.findElements(By.tagName("td"));
			for (WebElement column : columnDatas) {

				System.out.print(column.getText() + " || ");
			}
		}

	}

}
