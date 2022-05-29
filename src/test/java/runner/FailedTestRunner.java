package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "stepDefinitions", 
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				}
	)
public class FailedTestRunner extends AbstractTestNGCucumberTests{
	
	
	@DataProvider(parallel=true)
	public Object[][] scenario(){
		return super.scenarios();
	}
}
