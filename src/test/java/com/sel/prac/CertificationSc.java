package com.sel.prac;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CertificationSc {

	public static void main(String[] args) {
		handleCertification();
	}

	public static void handleCertification() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions opt = new ChromeOptions();
		// If any certification issue came we can use that
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);

		driver.manage().deleteAllCookies();

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

}
