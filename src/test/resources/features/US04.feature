
@db @wip4
Feature: As a data consumer, I want UI and DB book information are match.
  Scenario: Verify book information with DB
    Given user login as a librarian
    And I navigate to "Books" page
    When I open Book "Chordeiles Minor"
    Then book information must match the Database