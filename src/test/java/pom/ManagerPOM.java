package pom;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ManagerPOM  {
   private WebDriver driver;
    @FindBy(xpath = "//div[@class='center']")
    private WebElement centreSection;
    @FindBy(xpath = "(//button[@class='btn btn-lg tab'])[1]")
    private WebElement addCustomerButton;
//    @FindBy(xpath = "//input[@placeholder='First Name']" )          //input[@ng-model='fName']
@FindBy(xpath = " //input[@ng-model='fName']" )
private WebElement firstNameTextBox;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameTextBox;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeTextBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "(//button[@class='btn btn-lg tab'])[1]")
    private WebElement openAccountButton;
    @FindBy(id = "userSelect")
    private WebElement customerNameDropdown;
    @FindBy(xpath = "//select[@name='currency']")
    private WebElement currencyDropdown;
    @FindBy(xpath = "//button[text()='Process']")
    private WebElement processButton;

    @FindBy(xpath = "(//button[@class='btn btn-lg tab'])[2]")
    private WebElement customersButton;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerBar;
    @FindBy(xpath = "(//td[@class='ng-binding'])[1]")
    private WebElement retrieveCustomerPath;
    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    private WebElement deleteButton;
    public ManagerPOM(WebDriver dvr)
    {
        driver = dvr;
        PageFactory.initElements(driver, this);
    }


    public void verifyManagerPage()
    {
        Assert.assertTrue(centreSection.isDisplayed());
        System.out.println("Manager page is displayed with Add-Customer , Opeb-Account, Customer buttons");
    }
    public void clickAddCustomer()
    {
        Assert.assertTrue(addCustomerButton.isDisplayed());
        System.out.println("Add Customer button is displayed");
        addCustomerButton.click();;
    }

    public void clickOpenAccount() throws InterruptedException {
        Assert.assertTrue(openAccountButton.isDisplayed());
        System.out.println("Open Account button is displayed");
        openAccountButton.click();
        Thread.sleep(2000);

    }

    public void clickCustomers() throws InterruptedException {
        Assert.assertTrue(customersButton.isDisplayed());
        System.out.println("Customers button is displayed");
        customersButton.click();
        Thread.sleep(2000);

    }

    public void addNewCustomer(String firstName, String lastName, String postCode) throws InterruptedException {
        Assert.assertTrue(firstNameTextBox.isEnabled());
        firstNameTextBox.sendKeys(firstName);
        System.out.println("Successfuly entered First_Name as : " + firstNameTextBox.getText());

        Assert.assertTrue(lastNameTextBox.isEnabled());
        lastNameTextBox.sendKeys(lastName);
        System.out.println("Successfuly entered Last_Name as : " + lastNameTextBox.getText());

        Assert.assertTrue(postCodeTextBox.isEnabled());
       postCodeTextBox.sendKeys(postCode);
        System.out.println("Successfuly entered Post Code as : " + postCodeTextBox.getText());

        submitButton.click();
        System.out.println("Clicked on Add Customer submit button ");

        String alertExpectedText = "Customer added successfully";
        String alertActualText = driver.switchTo().alert().getText();
        if (alertExpectedText.equalsIgnoreCase(alertActualText)) {
            System.out.println("New Customer is added successfully and Alert is displayed");
        } else {
            System.out.println("New Customer is not added");
        }
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    public void opeNewAccount(String customerName, String currency) throws InterruptedException {
        Select select = new Select(customerNameDropdown);
        List<WebElement> allCustomers = select.getOptions();
        for (WebElement cust : allCustomers) {
            String customerText = cust.getText();
            if (customerText.equalsIgnoreCase(customerName)) {
                cust.click();
                break;
            }
        }
        System.out.println("Customer name is selected : "+customerName);
        Thread.sleep(3000);
        Select select1 = new Select(currencyDropdown);
        List<WebElement> allCurrency = select1.getOptions();
        for (WebElement cur : allCurrency) {
            String customerText = cur.getText();
            if (customerText.equalsIgnoreCase(currency)) {
                cur.click();
                break;
            }
        }
        Thread.sleep(2000);
        System.out.println("Currency  is selected : "+currency);
        processButton.click();
        Thread.sleep(2000);
        System.out.println("Clicked Process button for opening new Account ");

        String alertExpectedText = "Account created successfully";
        String alertActualText = driver.switchTo().alert().getText();
        if (alertExpectedText.equalsIgnoreCase(alertActualText)) {
            System.out.println("New Account is generated successfully and Alert is displayed");
        } else {
            System.out.println("New Account is not generated");
        }
       driver.switchTo().alert().accept();

    }

    public void searchCustomer(String name) throws InterruptedException {
        Assert.assertTrue(searchCustomerBar.isDisplayed());
        searchCustomerBar.click();
        searchCustomerBar.sendKeys(name);
        Thread.sleep(2000);
        String foundCustomer = retrieveCustomerPath.getText();
        if (foundCustomer.equalsIgnoreCase(name)) {
            System.out.println(name + " customer is successfully found");
        }
    }

    public void deleteCustomer() throws InterruptedException {
        Assert.assertTrue(deleteButton.isDisplayed());
        deleteButton.click();
        System.out.println("Customer is deleted successfully");
        Thread.sleep(3000);
    }


}
