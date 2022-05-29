package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageobjects.LandingPage;
import utils.TestContextSetup;

//Single Responsibility Principle
//Loosely coupled
//Factory Design Pattern

public class LandingPageStepDefinition {
	

	public TestContextSetup testContextSetup;
	public LandingPage lp;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.lp = testContextSetup.pageFactory.getLandingPage();
	}
	
	
	@SuppressWarnings("deprecation")
	@Given("user is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {

		Assert.assertTrue(lp.getTitleLandingPage().contains("GreenKart "));
	}

	@When("^user searched with shortcut (.+) and extracted actual name of product$")
	public void user_searched_with_shortcut_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	    
		lp.searchItem(shortName); 
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = lp.getProductName() .split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName+" is extracted from Home Page...");
	}
	
	@When("added {string} items of the selected product to cart")
	public void added_items_product(String quantity) {
		  
		lp.incrementQuantity(Integer.parseInt(quantity));
		lp.addToCart();
	}
}
