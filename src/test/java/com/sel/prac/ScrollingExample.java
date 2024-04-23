package com.sel.prac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingExample {
	

	public static void main(String[] args) {
//		scrollVertically();
		scrollHorizentalyAndVertically();

	}

	public static void scrollingExp() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		Actions act = new Actions(driver);

		// Scroll till the element
//		act.scrollToElement(driver.findElement(By.cssSelector("#mousehover"))).perform();
//		System.out.println("Scrolled Till Element");

		// Scroll till X and y axis
//		int deltaY = driver.findElement(By.cssSelector("#mousehover")).getRect().y;
//		new Actions(driver).scrollByAmount(0, deltaY).perform();
//		System.out.println("Scrolled Till X and Y cordinate");

		JavascriptExecutor exe = (JavascriptExecutor) driver;
//		exe.executeScript("window.scrollBy(0, 1300);");
		exe.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#mousehover")));
		System.out.println("Scroll using JS executor");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}

	public static void scrollVertically() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://datatables.net/examples/basic_init/scroll_y.html");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		WebElement exepectedEle = driver.findElement(
				By.xpath("//td[text()='Marketing Designer']/following-sibling::td[text()='San Francisco']"));
		WebElement name = driver.findElement(By.xpath(
				"(//td[text()='Marketing Designer']/following-sibling::td[text()='San Francisco']/preceding-sibling::td)[1]"));

		Actions act = new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//li[text()='Javascript']"))).perform();
		System.out.println("First Scroll");

		// Need to identify the window or table locator where need to scroll, then using
		// scrolltop we can scroll vertically
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.querySelector('.dataTables_scrollBody').scrollTop=1000");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Scrolled...");

		try

		{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}
	
	public static void scrollHorizentalyAndVertically() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/scroll/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		js.executeScript("window.scrollBy(0, 3600);");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		js.executeScript("document.querySelector(\"div[style$='position: relative; overflow: auto; width: 100%; height: 200px;']\").scrollTop=200");
		js.executeScript("document.querySelector(\"div[style$='position: relative; overflow: auto; width: 100%; height: 200px;']\").scrollLeft=300");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();
		
	}

}
