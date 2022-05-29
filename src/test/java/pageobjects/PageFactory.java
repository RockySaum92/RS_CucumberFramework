package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	
	public WebDriver driver;
	public LandingPage lp;
	public OffersPage op;
	public CheckoutPage checkoutPage;
	
	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		lp = new LandingPage(driver);
		return lp;
	}
	
	public OffersPage getOffersPage() {
		op = new OffersPage(driver);
		return op;
	}
	
	public CheckoutPage getcheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
