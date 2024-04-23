package org.alpha.test.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		tags="@smoke",
		features = "src/test/resources/features/FirstTestCase.feature", 
		glue = { "org.alpha.test.stepDefs", "com.alpha.MyHooks"},
		plugin = {  
					"pretty", 
					"html:target/cucumber-reports.html", 
					"json:target/cucumber-reports.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:target/cucumber", "rerun:target/failed.txt" }, 
					 dryRun= false, 
					 monochrome = true, 
					 publish = true
				)

/**
 * If cucumber-testNG is using need to extend AbstractTestNGCucumberTests class
 * and @RunWith(Cucumber.class) will not be added
 * @author basub
 *
 */
//@Test(retryAnalyzer = Retry.class)
public class TestRunner extends AbstractTestNGCucumberTests {
//		@Override
//		@DataProvider(parallel = true)
//		public Object[][] scenarios() {
//			return super.scenarios();
//		}
}
	// extedning AbstractTestNGCucumberTests class we can do parallel testin in
	// cucumber


