package org.alpha.test.stepDefs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import com.alpha.factory.DriverFactory;
import com.alpha.test.pages.ToolsQAHomePage;
import com.alpha.utils.ExcelUtils;
import com.alpha.utils.commonUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class DemoQAHomePage_Step {

	private static final String FILE_NAME = new File(System.getProperty("user.dir"))
			+ "/TestData/E2E_Automation_TestData.xlsx";

	private ToolsQAHomePage hp = new ToolsQAHomePage(DriverFactory.getDriver());

	ExcelUtils excelUtil = new ExcelUtils(FILE_NAME);

	@Given("I am on Tools QA Home Page")
	public void user_is_on_home_page() {

		System.out.println("---- USER IS ON HOME PAGE ----");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getDriver();
		jsExecutor.executeScript("window.scrollBy(0, " + 600 + ");");

	}

	@Then("the user should see the title {string}")
	public void the_user_should_see_the_title(String expectedTitle) {
		String actualTitle = hp.getTitleOfThePage();
		Assert.assertTrue(actualTitle.equals(expectedTitle));

	}

	@When("click on Training Iamge")
	public void click_on_training_iamge() {

		hp.clickingOnTrainingImage();
	}

	@Then("user Navigate to Traing page")
	public void user_navigate_to_traing_page() {

		String parentWindow = DriverFactory.getDriver().getWindowHandle();

		Set<String> windows = DriverFactory.getDriver().getWindowHandles();
		for (String window : windows) {
			if (window != parentWindow) {
				DriverFactory.getDriver().switchTo().window(window);

			}
		}

		Assert.assertTrue(hp.getHeaderTraining());
	}

	@Then("Below options should be there in the Page:")
	public void below_options_should_be_there_in_the_page(DataTable dataTable) {

		List<String> menuList = dataTable.asList(String.class);

		ArrayList<String> actualmenuList = hp.getMenuFromList();

		Assert.assertTrue(menuList.equals(actualmenuList));

	}

	@Given("Clicking on the Tutorials mennu")
	public void clicking_on_the_tutorials_mennu() {

		commonUtils.waitTillElementToClickable(DriverFactory.getDriver(), 30, hp.getTutorialTab());

		int attempts = 0;
		while (attempts < 5) {
			try {
				hp.getTutorialTab().click();
				break;
			} catch (StaleElementReferenceException e) {

			}
			attempts++;
		}

//		hp.getTutorialTab().click();
	}

	@Given("Mouseover on QA Practices")
	public void mouseover_on_qa_practices() {

		hp.moveToQAPractices();
	}

	@Then("ISTQB preparation should be visible")
	public void istqb_preparation_should_be_visible() {

//		Assert.assertTrue(hp.menuISTQBShould());
		Assert.assertFalse(hp.menuISTQBShould());
	}

	@Given("I am on the Student Registration Form page")
	public void i_am_on_the_student_registration_form_page() {
		hp.NavigateToPracticeForm();
	}

	@When("I enter the following valid information:")
	public void i_enter_the_following_valid_information() {

		List<String> firstName = excelUtil.readExcelData("Sheet1", "FirstName");
		List<String> lastName = excelUtil.readExcelData("Sheet1", "LastName");
		List<String> mobileNumber = excelUtil.readExcelData("Sheet1", "Mobile");

		commonUtils.enterValueToField(hp.getFormElement("firstName"), firstName.get(1));
		commonUtils.enterValueToField(hp.getFormElement("lastName"), lastName.get(1));
		commonUtils.enterValueToField(hp.getFormElement("userNumber"), mobileNumber.get(1));

	}

	@Given("I am on the Book Store page")
	public void i_am_on_the_book_store_page() {

		hp.NavigateToBookstore();
	}

	@When("Fetch The data from book store")
	public void fetch_the_data_from_book_store() {

		hp.fetchDataFromTable2();
	}

}
