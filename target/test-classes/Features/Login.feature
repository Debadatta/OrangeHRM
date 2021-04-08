
Feature: Login Feature
	@smoke
	Scenario Outline: User can able to login with valid login credentials
	
	Given User navigates to the website OrangeHRM
	When User enter valid Username as "<Username>" and Password as "<Password>"
	And User clicks the LOGIN button
	Then User should be able to redirect to Dashboard page
	
	Examples:
	
	| Username | Password |
	| Admin    | admin123 |
	
	Scenario Outline: User can unable to login with invalid login credentials
	
	Given User navigates to the website OrangeHRM
	When User enter valid Username as "<InvalidUsername>" and Password as "<InvalidPassword>"
	And User clicks the LOGIN button
	Then User should get the error message as "Invalid credentials"
	And User should not able to redirect to Dashboard page
	
	Examples:
	
	| InvalidUsername | InvalidPassword |
	| Admin1          | admin121       |
