package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.PageFactory;

public class TestContextSetup {
	public  WebDriver driver;
	public String landingPageProductName;
	public PageFactory pageFactory;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException {
		
		testBase = new TestBase();
		pageFactory = new PageFactory(testBase.webDeriverManager());
		genericUtils = new GenericUtils(testBase.webDeriverManager());
	}

}
