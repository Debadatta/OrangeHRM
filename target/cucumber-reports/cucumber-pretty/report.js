$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login Feature",
  "description": "",
  "id": "login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "User can able to login with valid login credentials",
  "description": "",
  "id": "login-feature;user-can-able-to-login-with-valid-login-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User navigates to the website OrangeHRM",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enter valid Username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User should be able to redirect to Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.user_navigates_to_the_website_OrangeHRM()"
});
formatter.result({
  "duration": 7505195600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.user_enter_valid_Username_and_Password()"
});
formatter.result({
  "duration": 3938575400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.user_clicks_the_LOGIN_button()"
});
formatter.result({
  "duration": 7346766600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.user_should_be_able_to_redirect_to_Dashboard_page()"
});
formatter.result({
  "duration": 76753900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.close_the_browser()"
});
formatter.result({
  "duration": 1314103100,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "User can unable to login with invalid login credentials",
  "description": "",
  "id": "login-feature;user-can-unable-to-login-with-invalid-login-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "User navigates to the website OrangeHRM",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "User enter invalid Username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User should get the error message as \"Invalid credentials\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "User should not able to redirect to Dashboard page",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.user_navigates_to_the_website_OrangeHRM()"
});
formatter.result({
  "duration": 43853500,
  "error_message": "org.openqa.selenium.remote.SessionNotFoundException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00272.45.0\u0027, revision: \u00275017cb8e7ca8e37638dc3091b2440b90a1d8686f\u0027, time: \u00272015-02-27 09:10:26\u0027\nSystem info: host: \u0027DESKTOP-L12U9K0\u0027, ip: \u0027192.168.43.91\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711.0.1\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:66)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:572)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:304)\r\n\tat StepDefinitions.StepDefinitions.user_navigates_to_the_website_OrangeHRM(StepDefinitions.java:22)\r\n\tat ✽.Given User navigates to the website OrangeHRM(Login.feature:14)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDefinitions.user_enter_invalid_Username_and_Password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.user_clicks_the_LOGIN_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Invalid credentials",
      "offset": 38
    }
  ],
  "location": "StepDefinitions.user_should_get_the_error_message_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.user_should_not_able_to_redirect_to_Dashboard_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
