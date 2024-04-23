package org.alpha.test.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed.txt",
		glue = { "org.alpha.test.stepDefs", "com.alpha.MyHooks"},
		plugin = { "pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"pretty", "json:target/cucumber-reports.json",
				"timeline:target/cucumber",},monochrome = true, publish = true)


//public class TestRunner{
//	
//
//}


public class Failed_TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	// extedning AbstractTestNGCucumberTests class we can do parallel testin in
	// cucumber

}
