@smoke
Feature: test login functionality

  Scenario Outline: user able to login
    Given firefox browser is open
    And user is on login page
    When user enters <username> and <password>
    And click on login button
    Then user navigated to the home page
    Examples:
      | username             | password  |
      | cptimepass@gmail.com | 12345 |
