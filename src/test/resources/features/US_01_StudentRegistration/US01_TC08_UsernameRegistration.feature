Feature: US01 TC08  User should enter User Name

  Background: user goes to Managementonschools web page
    Given user goes to "MosUrl"
    When user clicks on "RegisterLink"

  Scenario: TC_008 User enters a User Name Positive Senario

    And user scrolls into User Name box
    And user enters a User Name
    Then the Required text under the User Name box is NOT displayed

  Scenario: TC_008 User enters a User Name Negative Senario

    And user scrolls into User Name box
    And user clicks somewhere out of any Box
    Then the Required text under the User Name box is displayed