package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.Base;
import pom.HomePOM;
import pom.ManagerPOM;

import java.time.Duration;

public class ManagerFunctionalityStepDefinition extends Base {
    private static HomePOM h;
    private static  ManagerPOM manager;

    String firstName = "Missy";
    String lastName = "Kate";
    String postCode = "769854";
    String customerName = "Missy Kate";
    String currencyName = "Dollar";
    String seachCustomer = "Missy";
    @When("Manager clicks on Bank Manager Login button")
    public void manager_clicks_on_bank_manager_login_button() throws InterruptedException
    {
         h = new HomePOM(driver);
        h.clickManagerLogin();
    }
    @Then("Manager page is displayed")
    public void manager_page_is_displayed()
    {
        manager = new ManagerPOM(driver);
        manager.verifyManagerPage();
    }
    @Then("Manager clicks on Add Customer button to create new Customer")
    public void manager_clicks_on_add_customer_button_to_create_new_customer() throws InterruptedException {
       manager.clickAddCustomer();
       manager.addNewCustomer(firstName, lastName,postCode);

    }
    @Then("Manager clicks on  Open Account button to create new Account")
    public void manager_clicks_on_open_account_button_to_create_new_account() throws InterruptedException {
  ;   manager.clickOpenAccount();
      manager.opeNewAccount(customerName, currencyName);
    }
    @Then("Manager clicks on Customer button to validate customers")
    public void manager_clicks_on_customer_button_to_validate_customers() throws InterruptedException
    {
        manager.clickCustomers();
       manager.searchCustomer(seachCustomer);
    }
    @Then("To delete customers")
    public void to_delete_customers() throws InterruptedException {
       manager.deleteCustomer();
       h.clickHome();
       Base.tearDown();
    }

}
