$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login Feature",
  "description": "",
  "id": "login-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User can able to login with valid login credentials",
  "description": "",
  "id": "login-feature;user-can-able-to-login-with-valid-login-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User navigates to the website OrangeHRM",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enter valid Username as \"\u003cUsername\u003e\" and Password as \"\u003cPassword\u003e\"",
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
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "login-feature;user-can-able-to-login-with-valid-login-credentials;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 13,
      "id": "login-feature;user-can-able-to-login-with-valid-login-credentials;;1"
    },
    {
      "cells": [
        "Admin",
        "admin123"
      ],
      "line": 14,
      "id": "login-feature;user-can-able-to-login-with-valid-login-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "User can able to login with valid login credentials",
  "description": "",
  "id": "login-feature;user-can-able-to-login-with-valid-login-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User navigates to the website OrangeHRM",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enter valid Username as \"Admin\" and Password as \"admin123\"",
  "matchedColumns": [
    0,
    1
  ],
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
formatter.match({
  "location": "StepDefinitions.user_navigates_to_the_website_OrangeHRM()"
});
formatter.result({
  "duration": 18304043100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Admin",
      "offset": 30
    },
    {
      "val": "admin123",
      "offset": 54
    }
  ],
  "location": "StepDefinitions.user_enter_valid_Username_and_Password(String,String)"
});
formatter.result({
  "duration": 8761987899,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.user_clicks_the_LOGIN_button()"
});
formatter.result({
  "duration": 9204544101,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.user_should_be_able_to_redirect_to_Dashboard_page()"
});
formatter.result({
  "duration": 5101800899,
  "status": "passed"
});
});