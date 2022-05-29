package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.xpath("//*[contains(text(),'Tomato')]");
	private By topDeals = By.xpath("//a[contains(text(),'Top Deals')]");
	private By increment = By.xpath("//*[@class='increment' and text()='+']");
	private By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchItem() {
		driver.findElement(search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle(); 
	}
	
	public void incrementQuantity(int quantity) {
		int i = quantity-1;
		
		while(i>0) {
			
			driver.findElement(increment).click(); 
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
