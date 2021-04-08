
Feature: Dashboard Feature

Background: User is Logged in
	Given User navigates to the website OrangeHRM
	When User enter valid Username and Password
	And User clicks the LOGIN button
	Then User should be able to redirect to Dashboard page
	
Scenario: Validate the all the tabs present in dashboard page
	Then User should able to find Assign Leave tab
	And User should able to find Leave List tab
	And User should able to find Timesheets tab
	And User should able to find Apply Leave tab
	And User should able to find My Leave tab
	And User should able to find My Timesheet tab
	
Scenario: User should redirect to Login Page successfully after Logout 
	When User clicks the Logout link
	Then User should redirect to Login Page successfully
	And User should able to see the Login Panel
	

Scenario: User should able to see assign Leave form and fields

	When User clicks on the Assign Leave Launcher
	Then User should able to redirect to Assign Leave Page
	And User should able to see the Assign Leave form
	And User should able to see the Employee Name field
	And User should able to see the Leave Type field
	And User should able to see the Leave Balance field
	And User should able to see the From Date field
	And User should able to see the To Date field
	And User should able to see the Comment box
	And User should able to see the Assign Button
	 
	
	
