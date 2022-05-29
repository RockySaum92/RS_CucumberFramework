package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
//		tags = "@PlaceOrder ",
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"}
	)
public class TestNG_Runner extends AbstractTestNGCucumberTests{
	
	
	@DataProvider(parallel=true)
	public Object[][] scenario(){
		return super.scenarios();
	}
}
