package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageobjects.LandingPage;
import pageobjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public String offerPageProductName;
	 
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) shortcut in offers page$")
	public void user_searched_for_shortcut_in_offers_page(String shortName) throws InterruptedException {
		
	    switchOfferPage();
//	    OffersPage op = new OffersPage(testContextSetup.driver);
	    OffersPage op = testContextSetup.pageFactory.getOffersPage();
	    op.searchItem(shortName);
	    Thread.sleep(2000);
	    offerPageProductName = op.getProductName();    
	}
	
	public void switchOfferPage() {
		
//		LandingPage ls = new LandingPage(testContextSetup.driver);
		LandingPage ls = testContextSetup.pageFactory.getLandingPage();
		ls.selectTopDealsPage(); 
		testContextSetup.genericUtils.switchWindowToChild();
	}
 
	@SuppressWarnings("deprecation")
	@Then("Validate product name in offer page matches withlanding page")
	public void validate_product_name_in_offer_page_matches_withlanding_page() {
	    
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
} 
