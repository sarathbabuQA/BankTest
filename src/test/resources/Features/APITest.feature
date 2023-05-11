@APITests
Feature: API tests for Get,Post,Put,Delete methods
  
  Scenario: Get api service validation
    Given user navigated to list of api endpoints
    When click on any Get api service
    Then validate the get response body content
    And  user close the api browser

  Scenario: Post api service validation
    Given user navigated to list of api endpoints
    When click on any Post api service
    Then validate the post response body content
    And user close the api browser
    
  Scenario: Put api service validation
    Given user navigated to list of api endpoints
    When click on any Put api service
    Then validate the put response body content
    And user close the api browser
    
  Scenario: Delete api service validation
    Given user navigated to list of api endpoints
    When click on any Delete api service
    Then validate the delete response body content
    And user close the api browser