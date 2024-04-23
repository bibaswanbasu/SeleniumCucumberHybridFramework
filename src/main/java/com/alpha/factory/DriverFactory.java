package com.alpha.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	/**
	 * ThreadLocal is a class in Java that provides thread-safe storage. Each thread
	 * that accesses a ThreadLocal variable gets its own isolated copy of WebDriver
	 * instance. This is crucial for parallel test execution as it prevents tests
	 * from stepping on each other's browser sessions
	 */
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//	MutableCapabilities caps = new MutableCapabilities();

	public WebDriver init_driver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.out.println("[INFO] Browser is -> " + browser);
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
//			try {
//				tlDriver.set(new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps));
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("[INFO] Browser is -> " + browser);
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
//			try {
//				tlDriver.set(new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps));
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("[INFO] Browser is -> " + browser);
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new FirefoxDriver());
//			try {
//				tlDriver.set(new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps));
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} else {
			System.out.println(" ERROR: Not Supported Browser !!");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();

	}

	// The below synchronized keyword is used to run using threadlocal
	// synchronization would ensure proper initialization of the WebDriver instance
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

}
