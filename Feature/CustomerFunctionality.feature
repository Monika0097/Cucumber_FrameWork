Feature: Creating this feature file to verify the functionality of Bank Customer
  Background:
    Given Launch chrome browser
    When URL of XYZBank is provided
  Scenario: Verify the fuctionality of Customer
    When  Customer logs into the account
    Then    Account page is displayed
    Then   Customer clicks on Transactions button to see all tractions history
    Then   Customer clicks on Deposit button to deposit amount
    Then   Customer clicks on Withdrawal button to withdraw amount
    Then   Customer logs out from account and navigates to Home