@smoke @product-page
Feature: Product Detail Page Validation

  Background:
    Given user open application
    When user search for product "product.name"
    And click on the first product
    Then verify user is on product page

  Scenario: Navigate to product detail page and verify all necessary information is displayed
    And verify all necessary information is displayed

  Scenario: Navigate to product detail page and verify swipe is working on sponsored products
    When user scroll till sponsored products
    Then verify sponsored products are displayed
    When user swipe right till last sponsored product
    Then verify user reached in last product

  Scenario: Navigate to product detail page and verify seller information is displayed
    And verify seller information is displayed