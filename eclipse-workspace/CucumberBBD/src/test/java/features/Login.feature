Feature: Login

  Background: 
    Given As a user I will launch browser
    And Enter the url
    And click on myAccount

  @Functional
  Scenario: As a valid user I want to login to the appliaction by entering username and password
    When login page is displayed I will enter username and password
    And click on login
    Then I will verify the user name is present or not
    And Signout from the application

  @Functional
  Scenario: As a  user if I enter valid username and invalid password and click on login page should throgh an error
    When login page is displayed I will enter valid username "adhikarybristi1910@gmail.com" and invalid password "12345"
    And click on login
    Then verify that error message is displayed or not
    And close the browser
