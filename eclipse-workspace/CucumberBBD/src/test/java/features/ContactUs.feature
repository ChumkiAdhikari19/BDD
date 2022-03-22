Feature: Contact Us Feature

  Scenario Outline: contact us scenario with different set of data
    Given user navigates to contact us page
    When user fill the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on send button
    Then it shows successfull message "Your message has been successfully sent to our team."

    Examples: 
      | SheetName | RowNumber |
      | contactus |         0 |
      | contactus |         1 |
