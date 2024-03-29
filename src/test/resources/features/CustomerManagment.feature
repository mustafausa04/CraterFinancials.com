#Go to http://crater.primetech-apps.com/login crater login page.
#Enter the credentials email: dummy@primetechschool.com password: primetech@school
#Click the login button
#Navigate to thr customers tab
#Verify that a new customer button is displayed
@customerManagementTests @Regression
Feature: Customer management

#in the Bckground we put those 2 steps that we are already have them before in each step bellow
Background: 
    Given As an entity user, I am logged in
    When I navigate to the customers tab

  @newCustomerBTNTest @smokeTest
  Scenario: As a user when I navigate to the Customers Tab, I should see New customer button
    Then I should see the New Customer button displayed

  @newCustomerBasicInfoFormLabel
  Scenario: As a user when I navigate to the Customers Tab and Click on New customer button, I should see the basic information form label
    And I click on the New Customer button
    Then I should see the Basic Info form label

  @newCustomerBasicInfoFields
  Scenario: As a user when I navigate to the Customers Tab and click on New customer button, I should see the Basic Info fields
    And I click on the New Customer button
    Then I should see the Basic Info form label
    And I should see the fields Display Name, Primary Contact Name, Email, Primary Currency, Website, and Prefix

  @newCustomerTableList
  Scenario: As a user when I navigate to the Customers Tab, I should see the Customers Table List
    Then I should see the Customer List Table

  @customerTableColumns
  Scenario: As a user when I navigate to the Customers Tab, I should see the Customers Table with the appropriate columns
    Then I should see the Customer List Table
    And the following columns: NAME, PHONE , AMOUNT DUE, ADDED ON

  @customerTableMoreOptions
  Scenario: As a user when I navigate to the Customers Tab, I should see a more options button
    Then I should see the Customer List Table
    And a more link option for each customer with the options: Delete, Edit, View

  @newCustomerCreatedMessage
  Scenario: As a user when I navigate to the Customers Tab, when I create a user I should see a pop up message
    And I click on the New Customer button
    Then I enter a display name
    And click save
    Then I should see the pop up message "Customer created successfully"
    And I delete the customer

    @newCustomerInvalidNoInfo
    Scenario: As a user when I navigate to the Customers Tab and try creating a new customer without passing any info, I should get an error
    And I click on the New Customer button
    And click save
    Then I should see the error message “Field is required” below the Display Name field
    
    @newCustomers
    Scenario Outline: As a user, when I create a new customer I should see them in the customers table
    And I click on the New Customer button
    When I enter a valid "<Display Name>", "<Email>", "<State>", "<City>", and "<Zipcode>"
    And click save
    Then I should see the new customer in the data table
    And I delete the customer
    
    
    Examples:
    | Display Name|        Email       | State | City            |Zipcode|
    | Student1    | student1@gmail.com | VA    | Fairfax         | 12345 |
    | Student2    | student2@gmail.com | MD    | Rockville       | 00000 |
    | Student3    | student3@gmail.com | CA    | Orange County   | 54321 |
    
    @newCustomerFormErrorMessages
    Scenario Outline: As a user when I create a new customer, I should provide a valid display name and email
    And I click on the New Customer button
    When I enter invalid informatin: display name "<name>" and email "<email>"
    Then I should see the appropriate error message
    
    Examples:
    | name    | email             |
    | ab      | student@gmail.com |
    |         | student@gmail.com |
    | student | email             |