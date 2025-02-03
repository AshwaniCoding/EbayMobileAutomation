@regression @login
Feature: Verify Cart Persistence After Login and Logout

  Background:
    Given user open application
    When user click on sign in link
    Then verify user is on login page
    When user login with username "login.username" and password "login.password"
    And click on skip for now and do not allow button
    Then verify user is on homepage

  Scenario: Verify user login, add item to cart, logout and cart persistence after re-login
    When user search for product "product.name"
    And click on the first product
    Then verify user is on product page
    When user click on add to cart button and click on go to cart button
    Then verify product is added on cart page
    When user navigate back to search page
    And user click on My eBay icon
    Then verify user is on MyEbay page
    When user click on settings
    Then verify user is on setting page
    When user click on sign out button
    Then verify user is on homepage
    When user click on sign in link
    Then verify user is on login page
    When user login with username "login.username" and password "login.password"
    Then verify user is on homepage
    When user click on cart icon
    Then verify product is available on cart page