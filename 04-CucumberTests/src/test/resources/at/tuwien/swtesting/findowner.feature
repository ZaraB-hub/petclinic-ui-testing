Feature: Find existing owners

  Scenario: Find a single existing owner
    Given I am on the Find Owner page
    When I search for owner with last name "Franklin"
    Then the owner details should be displayed with name "George Franklin"

  Scenario: Find multiple owners
    Given I am on the Find Owner page
    When I search for owner with last name "b"
    Then I should see a list of owners whose last name start with "b"

  Scenario: Find all owners
    Given I am on the Find Owner page
    When I click the "Find Owner" button
    Then I should see a list of all owners
