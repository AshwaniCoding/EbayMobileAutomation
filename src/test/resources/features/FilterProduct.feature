@smoke
Feature: Verify Filter Option

  Scenario: Verify product price is in between filter price
    Given user open application
    When user search for product "product.name"
    Then verify user is on search product page
    When user click on filter link and select minimum price 10 and maximum price 100
    Then verify user getting all the product between selected price