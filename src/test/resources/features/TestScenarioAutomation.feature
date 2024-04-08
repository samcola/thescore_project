@MyTests
Feature: Team, League selection in Score Application

  Scenario: Select the favorite Team and Leagues
    Given User is at Start page
    When User clicks get started button
    Then User should see Leagues page
    When User selects League "NBA,NFL"
    Then User sees selected Leagues "NBA,NFL"
    When User clicks Continue button
    Then User sees the Teams page
    When User selects the teams in the leagues tab
      | NBA | NYK,BOS |
      | NFL | NYJ,BUF |
    Then User sees selected teams in the leagues tab
      | NBA | NYK,BOS |
      | NFL | NYJ,BUF |
    When User clicks Continue button
    And User clicks Done Button
    Then User sees the email sign up page
    When User clicks the maybe later button
    And User clicks Don't Allow notifications
    And User closes the pop up
    Then User sees the home page search bar

  Scenario: Select the favorite Team and Leagues
    Given User sees the Home Page
    When User clicks add button in the home page
    Then User sees the title "Add Favorites"
    When User selects a "league" with name "CFL Football"
    And User selects the "Standings" subtab
    Then User sees the "standings" subtab
    When User navigates back to home page
    When User selects a "team" with name "Toronto Raptors"
    And User selects the "Team Stats" subtab
    Then User sees the "Team stats" subtab





