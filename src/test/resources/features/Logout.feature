@regression @login
Feature: Validate Logout Functionality

  Background:
    Given user open application
    When user click on sign in link
    Then verify user is on login page
    When user login with username "login.username" and password "login.password"
    Then verify user is on homepage
    When user click on My eBay icon
    Then verify username is displayed on the top

  Scenario: Verify user can logout
    When user click on settings
    Then verify user is on setting page
    When user click on sign out button
    Then verify user is on homepage