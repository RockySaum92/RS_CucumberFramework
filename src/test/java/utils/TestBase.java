package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver webDeriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Global.properties");
		prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		
		if(driver==null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome") ) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			if(prop.getProperty("browser") == "firefox") {
				//firefox code
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		return driver;
	}
}
