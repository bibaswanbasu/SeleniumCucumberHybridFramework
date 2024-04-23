import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin {

	public static String username = "basu.bibaswan91@gmail.com";
	public static String password = "03561227520";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		// Add headless argument
		options.addArguments("--headless");

		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver(options);

		// Navigate to Gmail login page
		driver.get("https://mail.google.com");

		// Find the email input field and enter your email address
		WebElement emailInput = driver.findElement(By.id("identifierId"));
		emailInput.sendKeys(username);
		Thread.sleep(5000);

		// Click on the "Next" button
		WebElement nextButton = driver.findElement(By.id("identifierNext"));
		nextButton.click();

		// Wait for the password input field to be visible
		// This is just a basic example, in production code, you should use
		// WebDriverWait for better handling
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Find the password input field and enter your password
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys(password);
		Thread.sleep(5000);

		// Click on the "Next" button to submit the password
		WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
		passwordNextButton.click();

		// Add additional logic here, such as verifying successful login, navigating to
		// the inbox, etc.

		// Close the browser
		driver.quit();
	}

}
