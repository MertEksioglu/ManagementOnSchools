@US_13
Feature: Vice Dean should be able to create teacher

  Background: Sign in as vice dean
    Given user goes to "MosUrl"
    When user clicks on login button
    And user enters username "mrsnice"
    And user enters password "12345678"
    And user clicks on login button

  @TC_01
  Scenario Outline:TC_01_adding_lesson_program_successfully
    Given vice dean clicks on Teacher Management Option
    When vice dean enter "<lesson>"
    And vice dean enter "<name>","<surname>"
    And vice dean enter "<birthplace>" , "<email>" , "<phonenumber>"
    And vice dean choose gender
    And vice dean enter "<dateofbirth>", "<ssn>", "<username>" and "<password>"
    And vice dean click on the Submit button
    Then verify teacher saved successfully
    Examples:
      | lesson   | name  | surname | birthplace | email       | phonenumber  | dateofbirth | ssn         | username    | password |
      | Calculus | fatma | naz     | ulubey     | email@email | 545-543-5454 | 12-02-1970  | 213-43-8765 | fatmanaz012 | 12345678 |


