package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver ;
	By dashboardLabel = By.xpath("//h1[contains(text(),'Dashboard')]");
	
	By assignLeaveMenu = By.xpath("//span[contains(text(), 'Assign Leave')]"); 
	By leaveListMenu = By.xpath("//span[contains(text(), 'Leave List')]");
	By timesheetsMenu = By.xpath("//span[contains(text(), 'Timesheets')]");
	By applyLeaveMenu = By.xpath("//span[contains(text(), 'Apply Leave')]");
	By myLeaveMenu = By.xpath("//span[contains(text(), 'My Leave')]");
	By myTimesheetMenu = By.xpath("//span[contains(text(), 'My Timesheet')]");
	
	By profileMenu = By.id("welcome");
	By logoutLink = By.xpath("//a[contains(text(), 'Logout')]");
	
	public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
	public String findDashboardLabel() {
		return driver.findElement(dashboardLabel).getText();		
	}
	
	public boolean verifyAssignLeaveMenuPresence() {
		return driver.findElement(assignLeaveMenu).isDisplayed();
	}
	
	public boolean verifyLeaveListMenuPresence() {
		return driver.findElement(leaveListMenu).isDisplayed();
	}
	
	public boolean verifyTimesheetsMenuPresence() {
		return driver.findElement(timesheetsMenu).isDisplayed();
	}
	
	public boolean verifyApplyLeaveMenuPresence() {
		return driver.findElement(applyLeaveMenu).isDisplayed();
	}
	
	public boolean verifyMyLeaveMenuPresence() {
		return driver.findElement(myLeaveMenu).isDisplayed();
	}
	
	public boolean verifyMyTimesheetMenuPresence() {
		return driver.findElement(myTimesheetMenu).isDisplayed();
	}
	
	public void clickLogoutLink() throws InterruptedException {
		try {
			driver.findElement(profileMenu).click();
			Thread.sleep(10);
			driver.findElement(logoutLink).click();
		} catch(Exception e) {
			System.out.println("Logout Link not found.");
		}
		
	}
	
	public void clickAssignLeaveLauncher() {
		try {
			driver.findElement(assignLeaveMenu).click();
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("Assign Leave Launcher is not present");
		}
	}
}
