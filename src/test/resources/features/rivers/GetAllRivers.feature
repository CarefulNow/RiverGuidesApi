# Created by CarefulNow at 12/25/17
Feature: Selecting Rivers Guides
  This feature is to return river guid information to the user when requested.

  Scenario: The user sends a GET request looking for the application to return all of the river guides it contains
    Given The user wants River guides from the application
    When The user sends a GET request to "/rivers/getall"
    Then The river name should be "Dargle" and section name should be "Main Section"