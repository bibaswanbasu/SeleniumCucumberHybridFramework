package com.alpha.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.alpha.utils.commonUtils;

public class ToolsQAHomePage {

	public static WebDriver driver;
	public String menuText;

	public ToolsQAHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[contains(@class,'card')]//h5[text()='Elements']")
	private WebElement card_Elements;

	@FindBy(xpath = "//*[contains(@class,'card')]//h5[text()='Forms']")
	private WebElement card_Forms;

	@FindBy(xpath = "//ul[@class='menu-list']//*[text()='Practice Form']")
	private WebElement list_PracticeForm;

	@FindBy(xpath = "//*[@class='main-header'][text()='Elements']")
	private WebElement pageheaderElement;

	@FindBy(xpath = "//*[@alt='Selenium Online Training']")
	private WebElement onlineTrainlingImage;

	@FindBy(xpath = "//*[text()='Selenium Certification Training | Enroll Now | Study Online']")
	private WebElement headerTraining;

	@FindBy(xpath = "//ul[contains(@class,'navbar')]//a")
	private List<WebElement> navigationMenuOptions;

	@FindBy(xpath = "//*[contains(@class,'navbar')][text()='Tutorials']")
	private WebElement tabTutorials;

	@FindBy(xpath = "//*[@class='first-generation']/ul/li//*[text()='QA Practices']")
	private WebElement menuQAPractices;

	@FindBy(xpath = "//*[@class='second-generation']/ul/li//*[text()='ISTQB Preparation']")
	private WebElement menuISTQB;

	public WebElement getFormElement(String fieldName) {
		return driver.findElement(By.id(fieldName));

	}

	public void NavigateToPracticeForm() {

		card_Forms.click();
		commonUtils.waitTillElementToClickable(driver, 30, list_PracticeForm);

		list_PracticeForm.click();
		commonUtils.waitTillElementToClickable(driver, 30, getFormElement("firstName"));

	}

	public void NavigateToBookstore() {

		card_Forms.click();

		WebElement ElementHeader = driver.findElement(By.xpath("//span//*[text()='Elements']"));
		commonUtils.waitTillElementToClickable(driver, 30, ElementHeader);
		ElementHeader.click();

		WebElement WebTable = driver.findElement(By.xpath("//ul//*[text()='Web Tables']"));
		commonUtils.waitTillElementToClickable(driver, 30, WebTable);
		WebTable.click();

		WebElement firstRow = driver.findElement(By.xpath("(//div[@class='rt-table']//*[@class='rt-td'])[1]"));
		commonUtils.waitTillElementToClickable(driver, 30, firstRow);

	}

	public WebElement getTutorialTab() {
		return tabTutorials;
	}

	private WebElement menuFromList(String menuName) {
		return driver.findElement(By.xpath("//ul[@class='menu-list']//span[text()='" + menuName + "']"));
	}

	public void clickingOnTrainingImage() {

		commonUtils.waitTillElementToClickable(driver, 30, onlineTrainlingImage);

		onlineTrainlingImage.click();
	}

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public boolean getHeaderTraining() {
		return headerTraining.isDisplayed();
	}

	public boolean getElementheader() {

		commonUtils.waitTillVisibilityOfElement(driver, 30, pageheaderElement);

		return pageheaderElement.isDisplayed();

	}

	public ArrayList<String> getMenuFromList() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ArrayList<String> totalmenu = new ArrayList<>();

		for (WebElement menu : navigationMenuOptions) {
			System.out.println("Total Option Present -> " + navigationMenuOptions.size());

			totalmenu.add(menu.getText().toUpperCase());
		}
		return totalmenu;

	}

	public void moveToQAPractices() {

		commonUtils.waitTillElementToClickable(driver, 30, menuQAPractices);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Actions act = new Actions(driver);
		act.moveToElement(menuQAPractices).build().perform();

	}

	public boolean menuISTQBShould() {

		commonUtils.waitTillVisibilityOfElement(driver, 20, menuISTQB);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int attempts = 0;
		while (attempts < 5) {
			try {
				menuISTQB.isDisplayed();
			} catch (StaleElementReferenceException e) {
				// Retry the action
			}
			attempts++;
		}

		return menuISTQB.isDisplayed();

	}

	public List<WebElement> getCoulmnByRowNum(int rowNum) {

		return driver.findElements(By.xpath(
				"(//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))])["
						+ rowNum + "]/*[@class='rt-td']"));
	}

	public void fetchDataFromTable() {

		List<WebElement> totalColumns = driver.findElements(By.xpath(
				"(//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))])[1]/*[@class='rt-td'][text()]"));
		int numColumns = totalColumns.size();

		List<WebElement> tableRows = driver.findElements(By.xpath(
				"//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))]"));
		int numRows = tableRows.size();

		List<List<String>> tableData = new ArrayList<>();

		for (int rowIndex = 1; rowIndex <= numRows; rowIndex++) {
			// Create a list for the current column (So define the list inside loop)
			List<String> rowData = new ArrayList<>();

			for (int colIndex = 1; colIndex <= numColumns; colIndex++) {
				String cellXpath = "(//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))])["
						+ rowIndex + "]/*[@class='rt-td'][text()][" + colIndex + "]";
				WebElement cell = driver.findElement(By.xpath(cellXpath));

				rowData.add(cell.getText().trim());
			}

			tableData.add(rowData);
		}

		for (List<String> column : tableData) {
			System.out.println(column);
			if (column.contains("Cantrell")) {
				break;
			}
		}

	}

	// There is a web table, need to print all the coulmn value in list and at the
	// end print in a list of list
	public void fetchDataFromTable2() {

		List<WebElement> totalColumns = driver.findElements(By.xpath(
				"(//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))])[1]/*[@class='rt-td'][text()]"));
		int numColumns = totalColumns.size();

		List<WebElement> tableRows = driver.findElements(By.xpath(
				"//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))]"));
		int numRows = tableRows.size();

		List<List<String>> tableData = new ArrayList<>();

		for (int colIndex = 1; colIndex <= numColumns; colIndex++) {
			// Create a list for the current column (So define the list inside loop)
			List<String> columnData = new ArrayList<>();

			for (int rowIndex = 1; rowIndex <= numRows; rowIndex++) {
				String cellXpath = "(//*[@class='rt-table']//*[@class='rt-tbody']/*[@class='rt-tr-group']/*[not(contains(@class,'pad'))])["
						+ rowIndex + "]/*[@class='rt-td'][text()][" + colIndex + "]";
				WebElement cell = driver.findElement(By.xpath(cellXpath));

				columnData.add(cell.getText().trim());
			}

			tableData.add(columnData);
		}

		for (List<String> column : tableData) {
			System.out.println(column);
			if (column.contains("Cantrell")) {
				break;
			}
		}
	}

}
