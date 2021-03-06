package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runners.TestRunner;

import Pages.AssignLeave;
import Pages.DashboardPage;
import Pages.LoginPage;
import Lib.Log;

public class StepDefinitions extends TestRunner {
	public static final String WebsiteUrl = "https://opensource-demo.orangehrmlive.com/"; 

	
	@Given("^User navigates to the website OrangeHRM$")
	public void user_navigates_to_the_website_OrangeHRM() throws Throwable {		
		
		driver.get(WebsiteUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Log.info("User navigated to OrangeHRM application.");
	}

	@When("^User enter valid Username as \"(.*?)\" and Password as \"(.*?)\"$")
	public void user_enter_valid_Username_and_Password(String username, String password) throws Throwable {
	    LoginPage loginPage = new LoginPage(driver);
	    //loginPage.loginWithUsernameAndPassword(username, password);
	}
	
	@When("^User enter valid Username and Password$")
	public void user_enter_valid_Username_and_Password() throws Throwable {
	    LoginPage loginPage = new LoginPage(driver);	    
	    loginPage.loginWithUsernameAndPassword();
	}
	@When("^User enter invalid Username and Password$")
	public void user_enter_invalid_Username_and_Password() throws Throwable {
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.loginWithInvalidUsernameAndPassword();
	}
	

	@When("^User clicks the LOGIN button$")
	public void user_clicks_the_LOGIN_button() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.clickLoginButton();
	}

	@Then("^User should be able to redirect to Dashboard page$")
	public void user_should_be_able_to_redirect_to_Dashboard_page() throws Throwable {
	   DashboardPage dashboard = new DashboardPage(driver);
	   Assert.assertTrue(dashboard.findDashboardLabel().contains("Dashboard"));

	}
	
	@Then("^User should get the error message as \"(.*?)\"$")
	public void user_should_get_the_error_message_as(String arg1) throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.getInvalidLoginErrorMessage().contains("Invalid credentials"));
	}

	@Then("^User should not able to redirect to Dashboard page$")
	public void user_should_not_able_to_redirect_to_Dashboard_page() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.validateLoginPanel(), "Dashboard Page not Displayed.");
	}

	@Then("^User should able to find Assign Leave tab$")
	public void user_should_able_to_find_Assign_Leave_tab() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyAssignLeaveMenuPresence(), "Assign Leave menu not Displayed.");
	}

	@Then("^User should able to find Leave List tab$")
	public void user_should_able_to_find_Leave_List_tab() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyLeaveListMenuPresence(), "Leave List Menu not Displayed.");
	}

	@Then("^User should able to find Timesheets tab$")
	public void user_should_able_to_find_Timesheets_tab() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyTimesheetsMenuPresence(), "Timesheets Menu not Displayed.");
	}

	@Then("^User should able to find Apply Leave tab$")
	public void user_should_able_to_find_Apply_Leave_tab() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyApplyLeaveMenuPresence(), "Apply Leave Menu not Displayed.");
	}

	@Then("^User should able to find My Leave tab$")
	public void user_should_able_to_find_My_Leave_tab() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyMyLeaveMenuPresence(), "My Leave Menu not Displayed.");
	}

	@Then("^User should able to find My Timesheet tab$")
	public void user_should_able_to_find_My_Timesheets_tab() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.verifyMyTimesheetMenuPresence(), "My Timesheet Menu not Displayed.");
	}

	@When("^User clicks the Logout link$")
	public void user_clicks_the_Logout_link() throws Throwable {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickLogoutLink();
	}

	@Then("^User should redirect to Login Page successfully$")
	public void user_should_redirect_to_Login_Page_successfully() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.validateLoginPanel(), "Login Page is displayed.");
	}

	@Then("^User should able to see the Login Panel$")
	public void user_should_able_to_see_the_Login_Panel() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.validateLoginPanel(), "Login Panel is displayed.");
	}
	@When("^User clicks on the Assign Leave Launcher$")
	public void user_clicks_on_the_Assign_Leave_Launcher() throws Throwable {
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickAssignLeaveLauncher();
	}

	@Then("^User should able to redirect to Assign Leave Page$")
	public void user_should_able_to_redirect_to_Assign_Leave_Page() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfAssignLeaveHeader(), "Assign Leave Page is displayed.");
	}

	@Then("^User should able to see the Assign Leave form$")
	public void user_should_able_to_see_the_Assign_Leave_form() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfAssignLeaveForm(), "Assign Leave form is displayed.");
	}

	@Then("^User should able to see the Employee Name field$")
	public void user_should_able_to_see_the_Employee_Name_field() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfEmployeeName(), "Employee Name field is displayed.");
	}

	@Then("^User should able to see the Leave Type field$")
	public void user_should_able_to_see_the_Leave_Type_field() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfLeaveType(), "Leave Type field is displayed.");
	}

	@Then("^User should able to see the Leave Balance field$")
	public void user_should_able_to_see_the_Leave_Balance_field() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfLeaveBalance(), "Leave Balance field is displayed.");
	}

	@Then("^User should able to see the From Date field$")
	public void user_should_able_to_see_the_From_Date_field() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfFromDate(), "From Date is displayed.");
	}

	@Then("^User should able to see the To Date field$")
	public void user_should_able_to_see_the_To_Date_field() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfToDate(), "To Date is displayed.");
	}

	@Then("^User should able to see the Comment box$")
	public void user_should_able_to_see_the_Comment_box() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfComment(), "Comment Box is displayed.");
	}

	@Then("^User should able to see the Assign Button$")
	public void user_should_able_to_see_the_Assign_Button() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		Assert.assertTrue(assignLeave.validatePresenceOfAssignButton(), "Assign Button is displayed.");
	}
	
	@When("^User enters Employee Name as \"(.*?)\"$")
	public void user_enters_Employee_Name_as(String name) throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.enterEmployeeName(name);
	}

	@When("^User selects Leave Type as \"(.*?)\"$")
	public void user_selects_Leave_Type_as(String leaveType) throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.selectLeaveType(leaveType);
	}

	@When("^User selects From Date$")
	public void user_selects_From_Date() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.selectFromDate();
	}

	@When("^User selects To Date$")
	public void user_selects_To_Date() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.selectToDate();
	}

	@When("^User enters Comment in Comment box as \"(.*?)\"$")
	public void user_enters_Comment_in_Comment_box_as(String arg1) throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.enterComment();
	}

	@When("^User clicks Assign button$")
	public void user_clicks_Assign_button() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.clickAssignButton();
	}

	@Then("^User should get popup if Leave Balance is less$")
	public void user_should_get_popup_if_Leave_Balance_is_less() throws Throwable {
		AssignLeave assignLeave = new AssignLeave(driver);
		assignLeave.checkLeaveBalAndValidateConfirmation();
	}

	@When("^User clicks OK$")
	public void user_clicks_OK() throws Throwable {
	   
	}

	@Then("^User should get success message$")
	public void user_should_get_success_message() throws Throwable {
	    
	}

	@Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
}
