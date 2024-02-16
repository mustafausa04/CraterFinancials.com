@dashboardTests @Regression
Feature: Dashboard home page
#we moved this step "Then I should be on the Dasboard home page" me and Bijan from all scenario
#because it was not working so we moved it to the Background because we will use it in every scenario but then it worked so i put them back
Background:
   Given As an entity user, I am logged in
   #Then I should be on the Dasboard home page
   
   @SalesandExpensesHeader
   Scenario: As a user when I log in, I should be on the dashboard page and see the header sales and expenses
   Then I should be on the Dasboard home page
   And I should see the header "Sales & Expenses"
   
   @dashboardButtons  @smokeTest
   Scenario: As a user when I log in, I should see the four buttons
   Then I should be on the Dasboard home page
   And I should see the buttons "Amount Due", "Customers", "Invoices", and "Estimates"
   
   @dashboardHeaders
   Scenario: As a user when I log in, I should see the headers
   Then I should be on the Dasboard home page
   And I should see the headers "Due Invoices" and "Recent Estimates"
   
   @dashboardGraph
   Scenario: As a user when I log in, I should see the graph with a dropdown menu
   Then I should be on the Dasboard home page
   And I should see the graph wth a drop down menu having the options "This year" and "Previous year"