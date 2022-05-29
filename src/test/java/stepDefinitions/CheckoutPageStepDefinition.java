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
import pageobjects.CheckoutPage;
import pageobjects.LandingPage;
import utils.TestContextSetup;

//Single Responsibility Principle
//Loosely coupled
//Factory Design Pattern

public class CheckoutPageStepDefinition {
	

	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		checkoutPage = testContextSetup.pageFactory.getcheckoutPage();
	}

	@SuppressWarnings("deprecation")
	@Then("Validate user has ability to enter promo code and place the order")
	public void Validate_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}
	
	@SuppressWarnings("deprecation")
	@Then("^user proceeds to checkout and validate the (.+) items on checkout page$")
	public void user_proceeds_to_checkout(String name) {
		
		checkoutPage.checkOutItems();
//		String productName = checkoutPage.getProductName();
//		Assert.assertEquals(name, productName);
	}
}
