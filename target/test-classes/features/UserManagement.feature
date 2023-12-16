#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

# if you run this tag "@userManagement" it will run everything
@userManagement
Feature: User management / access management

# we could add @smokeTest tag and when ever we run the cucumber it will apply the smoke test for the scenario that is 
# been tagged with that only
  @validLogin @smokeTest
  Scenario: User should be able to login with valid credentials
    Given As a user, I am on the login page
    When I enter valid useremail and valid password
    And Click on login button
    Then I should be logged in
    
# Note: if there are 2 steps are the same like "Given As a user, I am on the login page" in more than one Scenario
# cucmber will use only one, no need to use these duplicate steps everytime in all scenarios   
#if you run this tag for ex it will run only this part not the whole tags
  @invalidEmailLogin
  Scenario: Invalid email login attempts
    Given As a user, I am on the login page
    When I enter invalid username and valid password
    And Click on login button
    #here we could add a message and it will appear as a string in the console
    Then I should see an error message "These credentials do not match our records." displays
    And I should not be logged in
