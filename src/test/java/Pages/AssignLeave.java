package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import Lib.Util;

public class AssignLeave {
	WebDriver driver;
	By assignLeaveForm = By.id("frmLeaveApply");
	By employeeName = By.id("assignleave_txtEmployee_empName");
	By leaveType = By.id("assignleave_txtLeaveType");
	By leaveBalance = By.id("assignleave_leaveBalance");
	By fromDate = By.id("assignleave_txtFromDate");
	By toDate = By.id("assignleave_txtToDate");	
	By comment = By.id("assignleave_txtComment");
	By assignButton = By.id("assignBtn");
	By assignLeaveHeader = By.xpath("//h1[contains(text(), 'Assign Leave')]");
	By leaveBalanceConfirm = By.id("leaveBalanceConfirm");
	
	
	public AssignLeave(WebDriver driver) {
        this.driver = driver;
    }
	
	public boolean validatePresenceOfAssignLeaveHeader() {
		return driver.findElement(assignLeaveHeader).isDisplayed();
	}
	
	public boolean validatePresenceOfAssignLeaveForm() {
		return driver.findElement(assignLeaveForm).isDisplayed();
	}
	
	public boolean validatePresenceOfEmployeeName() {
		return driver.findElement(employeeName).isDisplayed();
	}
	
	public boolean validatePresenceOfLeaveType() {
		return driver.findElement(leaveType).isDisplayed();
	}
	
	public boolean validatePresenceOfLeaveBalance() {
		return driver.findElement(leaveBalance).isDisplayed();
	}
	
	public boolean validatePresenceOfFromDate() {
		return driver.findElement(fromDate).isDisplayed();
	}
	
	public boolean validatePresenceOfToDate() {
		return driver.findElement(toDate).isDisplayed();
	}
	
	public boolean validatePresenceOfComment() {
		return driver.findElement(comment).isDisplayed();
	}

	public boolean validatePresenceOfAssignButton() {
		return driver.findElement(assignButton).isDisplayed();
	}
	
	public void enterEmployeeName(String name) {
		driver.findElement(employeeName).sendKeys(name);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//strong[contains(text(), '"+ name+"')]")));
	}
	
	public void selectLeaveType(String leave_Type) {
		Select leaveTypeSelect = new Select(driver.findElement(leaveType));
		leaveTypeSelect.selectByVisibleText(leave_Type);
	}
	
	public void selectFromDate() {
		Util util = new Util();
		String strDate = util.dateFormater("yyyy-MM-dd", 1);
		driver.findElement(fromDate).clear();
		driver.findElement(fromDate).sendKeys(strDate);
	}
	
	public void selectToDate() {
		Util util = new Util();
		String strDate = util.dateFormater("yyyy-MM-dd", 3);
		driver.findElement(toDate).clear();
		driver.findElement(toDate).sendKeys(strDate);
	}
	
	public void enterComment() {
		driver.findElement(comment).sendKeys("Added Personal Leave");
	}
	
	public void clickAssignButton() throws InterruptedException {
		driver.findElement(assignButton).click();
		Thread.sleep(100);
	}
	
	public int checkLeaveBalance() {
		String leaveBalanceAmt = driver.findElement(leaveBalance).getText();
		int leaveCount = Integer.parseInt(leaveBalanceAmt);  
		return leaveCount;
	}
	
	public void checkLeaveBalAndValidateConfirmation() {
		try {
			if(checkLeaveBalance() > 0) {
				
			} else {
				driver.findElement(leaveBalanceConfirm).isDisplayed();
			}
		} catch(Exception e) {
			
		}
	}
}
