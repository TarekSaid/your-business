Feature: Homepage
  As a potential user
  I want to access the YourBusiness page
  In order to learn more about it

  Background:
    Given that I am using Firefox

  Scenario: Browsing the home page
    When I open the home page
    Then the title should be "Home | YourBusiness"
    And I should see 2 links to the home page
    And I should see 1 link to the help page
    And I should see 1 link to the about page

  Scenario: Browsing the help page
    When I open the help page
    Then the title should be "Help | YourBusiness"

  Scenario: Browsing the about page
    When I open the about page
    Then the title should be "About | YourBusiness"