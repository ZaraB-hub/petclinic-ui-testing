Feature: DuckDuckGo Search
  As a user I want to get a list of web results related to a search term.

  Scenario: Search with DuckDuckGo
    Given I am on the search page "https://duckduckgo.com/"
    When I enter the search term "testing"
    Then I should be on the results page