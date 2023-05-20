package stepDefinition;

import io.cucumber.java.en.*;
import pom.Base;
import pom.CustomerPOM;
import pom.HomePOM;
import pom.ManagerPOM;

public class CustomerFunctionlityStepDefinition extends Base {
    public static HomePOM home ;
    public static CustomerPOM customer;
    String name="Hermoine Granger";
    String deposit= "4000";
    String withdraw="2500";
    @When("Customer logs into the account")
    public void customerLogsIntoTheAccount() throws InterruptedException
    {
    home= new HomePOM(driver);
    customer= new CustomerPOM(driver);
    home.clickCustomerLogin();
    customer.customerLogin(name);
    }
    @Then("Account page is displayed")
    public void account_page_is_displayed()
    {
        customer.customerPageVerify();
    }
    @Then("Customer clicks on Transactions button to see all tractions history")
    public void customer_clicks_on_transactions_button() throws InterruptedException
    {
         customer.seeTransactins();
    }
    @Then("Customer clicks on Deposit button to deposit amount")
    public void customer_clicks_on_deposit_button_to_deposit_amount() throws InterruptedException {
     customer.depositeAmount(deposit);
    }
    @Then("Customer clicks on Withdrawal button to withdraw amount")
    public void customer_clicks_on_withdrawal_button_to_withdraw_amount() throws InterruptedException {
        customer.withdrawAmount(withdraw);
    }
    @Then("Customer logs out from account and navigates to Home")
    public void customer_logs_out_from_account_and_navigates_to_home() throws InterruptedException {
     customer.customerLogout();
     Base.tearDown();
    }


}
