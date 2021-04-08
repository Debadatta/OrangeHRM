package Pages;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver ;
	By userName = By.id("txtUsername");
    By password = By.id("txtPassword");
    By loginButton =By.id("btnLogin");
    By invalidLoginMessage = By.id("spanMessage");
    By loginPanel = By.id("logInPanelHeading");

    public LoginPage(WebDriver driver) {
        this.driver = driver;    
        
    }

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }
    
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }
    
    public void loginWithUsernameAndPassword(String username, String password) {
    	this.setUserName(username);
    	this.setPassword(password);
    }

	public void clickLoginButton() {
		driver.findElement(loginButton).click();		
	}
	
	public String getInvalidLoginErrorMessage() {
		return driver.findElement(invalidLoginMessage).getText();		
	}
	
	public Boolean validateLoginPanel() {
		return driver.findElement(loginPanel).isDisplayed();
	}
}
