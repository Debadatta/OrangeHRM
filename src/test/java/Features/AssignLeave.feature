Feature: Assign Leave Feature

Background: User is Logged in
	Given User navigates to the website OrangeHRM
	When User enter valid Username and Password
	And User clicks the LOGIN button
	Then User should be able to redirect to Dashboard page
	When User clicks on the Assign Leave Launcher
	Then User should able to redirect to Assign Leave Page
	
@smoke1	
Scenario Outline: User should able to assign leave successfully
	When User enters Employee Name as "<Employee Name>"
	And User selects Leave Type as "<Leave Type>"
	And User selects From Date 
	And User selects To Date 
	And User enters Comment in Comment box as "<Comment>"
	And User clicks Assign button
	Then User should get popup if Leave Balance is less 
	When User clicks OK 
	Then User should get success message  
	
Examples:
	| Employee Name | Leave Type | Comment |
	| Jordan Mathews| US - Vacation| Personal Leave |
 


	
	
	
	
	 