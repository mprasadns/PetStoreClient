Feature: Ability to get Result from Pet Store API
  Scenario: Get the list of Pets based on status
    Given I have the status as available for the Pets list
    When I request the list of Pets with the status available
    Then I should have list of all the Pets based on the status available
