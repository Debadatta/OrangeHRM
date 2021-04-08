package Lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	private static final String driverPath = "chromedriver.exe";
	public WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();       
	}
	
	@After
	public void Clean() {
		driver.close();
	}
}
