@smoke
Feature: Login Feature

	Scenario: User can able to login with valid login credentials
	
	Given User navigates to the website OrangeHRM	
	When User enter valid Username and Password
	And User clicks the LOGIN button
	Then User should be able to redirect to Dashboard page
	Then Close the browser
	
	Scenario: User can unable to login with invalid login credentials
	
	Given User navigates to the website OrangeHRM
	When User enter invalid Username and Password
	And User clicks the LOGIN button
	Then User should get the error message as "Invalid credentials"
	And User should not able to redirect to Dashboard page
	Then Close the browser
	
