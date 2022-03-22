Feature: Shop feature

  Background: 
    Given enter the URL "http://practice.automationtesting.in/"

  Scenario: As a user I will drag the slider for filtering the price
    And click on Shop Menu
    When Shop page is displayed i will go on price slider
    And Adjust the slider 150 to 350
    And Click on filter button
    Then verify the product price between 150 to 350 or not

  Scenario: As a user I will apply default sort in shop page
    When Home is displayed click on shop
    And select default sorting dropdown and select "Sort by popularity"
    Then get all the book name and print in console
