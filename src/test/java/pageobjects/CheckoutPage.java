 package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By cartBag = By.xpath("//*[@alt='Cart']");
	private By checkOutBag = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoBtn = By.xpath("//button[contains(text(),'Apply')]");
	private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	private By productName = By.xpath(" //*[@class='product-name' and contains(text(),'Tomato')]");
	
	public void checkOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutBag).click(); 
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getProductName() {
		
		String name = driver.findElement(productName).getText().split("-")[0].trim();
		System.out.println("Product Name on Checkout page --> "+name);
		return name;
	}
	
}
