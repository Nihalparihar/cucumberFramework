Feature: Automate login functionality
  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address "nihalsinghparihar@gmail.com" into the email field
    And User enters valid password "parihar" into password field
    And User clicks on login button
    Then User should successfully get login

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address "nihalsinghparihar1@gmail.com" into the email field
    And User enters invalid password "parihar1" into password field
    And User clicks on login button
    Then User should get proper warning message about invalid credintials

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address "nihalsinghparihar1@gmail.com" into the email field
    And User enters valid password "parihar" into password field
    And User clicks on login button
    Then User should get proper warning message about invalid credintials

  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email address "nihalsinghparihar@gmail.com" into the email field
    And User enters invalid password "parihar1" into password field
    And User clicks on login button
    Then User should get proper warning message about invalid credintials

  Scenario: Login without entering email and password
    Given User navigates to login page
    When User does not enter email into the email field
    And User does not enter password into password field
    And User clicks on login button
    Then User should get proper warning message about invalid credintials


