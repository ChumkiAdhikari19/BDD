Feature: Add To basket

  Background: 
    Given enter the Url "http://practice.automationtesting.in/"

  Scenario: As a user I want to add a product to basket
    When home page is displayed click on shop
    Then add any product by clicking on AddToBasket button
    Then click on ViewBasket
    And verify same product added
