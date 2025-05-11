Feature: Edit an existing owner

  Scenario: Successfully update owner information
    Given I am on the Find Owner page
    When I search for owner with last name "Franklin"
    And I click the "Edit Owner" button
    And I update the owner form with city "Vienna"
    And I click on the "Update Owner" button
    Then the owner details should be displayed with name "George Franklin" and city "Vienna"
