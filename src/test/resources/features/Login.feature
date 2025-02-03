@regression @login
Feature: Validate Login Functionality

  Background:
    Given user open application
    When user click on sign in link
    Then verify user is on login page

  Scenario: Verify user can login with valid credentials
    When user login with username "login.username" and password "login.password"
    And click on skip for now and do not allow button
    Then verify user is on homepage
    When user click on My eBay icon
    Then verify username is displayed on the top

  Scenario Outline: Verify user cannot login with invalid credentials
    When user login with username "<username>" and password "<password>"
    Then verify user cannot login
    Examples:
      | username | password |
      | invalid  | invalid  |
      | admin    | password |
