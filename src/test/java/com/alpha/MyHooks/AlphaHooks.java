package com.alpha.MyHooks;

import com.alpha.factory.DriverFactory;
import com.alpha.utils.configReader;

import io.cucumber.java.*;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class AlphaHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private configReader cnfRdr;
	Properties prop;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Its before All...............................");

	}

	@Before(order = 0)
	public void before_or_after(io.cucumber.java.Scenario scenario) {
		cnfRdr = new configReader();
		prop = cnfRdr.init_prop();
	}

	@Before(order = 1)
	public void setUp() {
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);

		DriverFactory.getDriver().get(prop.getProperty("url"));

	}

	@After(order = 1)
	public void closeBrowser() {
		driver.quit();
	}

//	@AfterStep
//	public void addScreenshot(Scenario sc) {
//
////		byte[] screenshot = captureScreenshot.takeScreenshot(driver);
////		sc.attach(screenshot, "image/png", sc.getName());
//
//		if (sc.isFailed()) {
////			captureScreenshot.takeScreenshotAs(driver, sc.getName());
//			byte[] screenshot = captureScreenshot.takeScreenshot(driver);
//			sc.attach(screenshot, "image/png", sc.getName());
//		}
//	}

}
