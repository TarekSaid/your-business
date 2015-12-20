Feature: Homepage
  As a potential user
  I want to access the YourBusiness page
  In order to learn more about it

  Background:
    Given that I am using Firefox

  Scenario: Browsing the home page
    When I open the home page
    Then the title should be "Home | YourBusiness"
    And the page title should be "Home"

  Scenario: Browsing the help page
    When I open the help page
    Then the title should be "Help | YourBusiness"
    And the page title should be "Help"