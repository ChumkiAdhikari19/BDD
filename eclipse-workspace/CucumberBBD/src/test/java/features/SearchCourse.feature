Feature: Search Course feature

  Background: 
    Given I want launch the "chrome" browser
    And I enter the url "http://practice.automationtesting.in/"

  @Regression @End2End
  Scenario Outline: As a user I want search for multiple course and get the title of the course
    When homw page is  displayed I want search for "<course>"
    And get count each course and title of course
    Then verify in the search result "<course>" name is there or not
    And close all the browser

    Examples: 
      | course      |
      | html        |
      | android     |
      | Java script |

  @Sanity
  Scenario: As a valid after login fill all the account details
    
    And go to my account tab
    When login page is displayed enter the username "adhikarybristi1910@gmail.com" and password "Chumadhikari@19"
    And click On login
    And click on account details
    And In account details page fill first name, last name, current password, new password and confirm password
      | first name | Lastname | Current password | Newn password     | confirm password  |
      | chumki     | ad       | Chumadhikari@19  | Chumadhikari@1910 | Chumadhikari@1910 |
    And click on save changes
    Then verify the successfull message displayed or not "Account details changed successfully."
