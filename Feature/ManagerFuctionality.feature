Feature: Creating this feature file to verify the functionality of Bank Manager
  Background:
    Given Launch chrome browser
    When URL of XYZBank is provided
    Scenario: Verify the fuctionality of Manager
      When  Manager clicks on Bank Manager Login button
      Then   Manager page is displayed
      Then   Manager clicks on Add Customer button to create new Customer
      Then   Manager clicks on  Open Account button to create new Account
      Then   Manager clicks on Customer button to validate customers
      And    To delete customers
