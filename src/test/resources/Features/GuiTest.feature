@GuiTests
Feature: Gui Tests on Home page and Support page
  
  Scenario: verify list of defferent end points
    Given user provide application url
    When  user navigated to home page
    Then  check home page information
    And   user close the browser
    
  Scenario: verify selected api request and response
    Given user provide application url
    When  user navigated to home page
    Then  click on anyone api method
    And   application should display api response data
    And   user close the browser
    
  Scenario: verify navigate button to support page
    Given user provide application url
    When  user navigated to home page
    Then  application has button to navigate support page
    And   user close the browser
    
  Scenario: verify list of one-time and monthly options
    Given user provide application url
    When  user navigated to home page
    And   click on SupportReqRes button
    Then  application has one-time and monthly options
    And   user close the browser
    
  Scenario: verify upgrade details
    Given user provide application url
    When  user navigated to home page
    And   click on Upgrade button
    Then  application display upgrade details
    And   user close the browser
    