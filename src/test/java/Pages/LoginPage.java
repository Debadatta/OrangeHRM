package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Lib.Log;
import Lib.Util;

public class LoginPage {
	
	WebDriver driver ;
	By userName = By.cssSelector("input#txtUsername");
    By password = By.cssSelector("input#txtPassword");
    By loginButton =By.id("btnLogin");
    By invalidLoginMessage = By.id("spanMessage");
    By loginPanel = By.id("logInPanelHeading");
    Util util = new Util();
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;    
        
    }

    public void setUserName(String strUserName){
    	try {    		
    		util.waitUntilElementPresent(driver,  userName);
    		driver.findElement(userName).sendKeys(strUserName);
    	} catch(Exception e) {
    		Log.error("Username field not found.");
    	}
    }
    
    public void setPassword(String strPassword) {
    	try {    		
    		util.waitUntilElementPresent(driver,  password);
    		driver.findElement(password).sendKeys(strPassword);
    	} catch(Exception e) {
    		Log.error("Password field not found.");
    	}
    }
    
    public void loginWithUsernameAndPassword(String username, String password) {
    	this.setUserName(username);
    	this.setPassword(password);
    }

	public void clickLoginButton() {
		try {    		
    		util.waitUntilElementPresent(driver, loginButton);
    		driver.findElement(loginButton).click();
		} catch(Exception e) {
			Log.error("Login Button not found.");
		}
	}
	
	public String getInvalidLoginErrorMessage() {
		try {    		
    		util.waitUntilElementPresent(driver, invalidLoginMessage);    			
		} catch(Exception e) {
			Log.error("Login Error Message not found.");
		}
		return driver.findElement(invalidLoginMessage).getText();	
	}
	
	public Boolean validateLoginPanel() {
		try {    		
    		util.waitUntilElementPresent(driver, loginPanel);    			
		} catch(Exception e) {
			Log.error("Login Panel not found.");
		}
		return driver.findElement(loginPanel).isDisplayed();
	}
}
