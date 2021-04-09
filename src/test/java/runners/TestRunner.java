package runners;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Lib.Log;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = {"@smoke"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class TestRunner {
	protected static WebDriver driver=null;
	private TestNGCucumberRunner testNGCucumberRunner;
	 
    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "version"})
    public void setUpClass(String browser, String version) throws Exception {
    	DOMConfigurator.configure("log4j.xml");    	 
    	 Log.startTestCase("Selenium_Test_001");
    	if(browser.equalsIgnoreCase("firefox")) {
    		
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    		Log.info("Firefox Browser started.");
    		
    	} else if(browser.equalsIgnoreCase("chrome")) {
    		
	    	ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().browserVersion(version).setup();
			options.addArguments("start-maximized"); 
			options.addArguments("enable-automation"); 
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation"); 
			options.addArguments("--disable-gpu"); 
			driver = new ChromeDriver(options); 
			Log.info("Chrome Browser started.");
        } else {
        	Log.error("Browser is not correct.");
			throw new Exception("Browser is not correct");
		}
    	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
        
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	Log.endTestCase("Selenium_Test_001");
        //testNGCucumberRunner.finish();
        //driver.close();
    }
}