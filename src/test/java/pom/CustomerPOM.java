package pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerPOM {
    private WebDriver driver;
    @FindBy(xpath="//select[@id='userSelect']")
    private WebElement customerDropdown;
    @FindBy(xpath="//button[text()='Login']")
   private WebElement loginButton;
    @FindBy(xpath = "//span[@class='fontBig ng-binding']")
    private WebElement customerName;

    @FindBy(xpath = "//select[@id='accountSelect']")
    private WebElement accountIdDropdown;
    @FindBy(xpath = "(//div[@ng-hide='noAccount'])[1]")
    private WebElement accountDetailsSection;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    private WebElement transactionButton;
    @FindBy(xpath = "//button[@ng-click='back()']")
    private WebElement backButton;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped']")
    private WebElement transactionTable;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    private WebElement depositButton;
    @FindBy(xpath = "//label[text()='Amount to be Deposited :']")
    private WebElement depositeSection;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement depositAmountBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement depositeSubmitButton;
    @FindBy(xpath = "//span[text()='Deposit Successful']")
    private WebElement depositeConfirmation;


    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    private WebElement withdrawalButton;
    @FindBy(xpath = "//label[text()='Amount to be Withdrawn :']")
    private WebElement withdrawalSection;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement withdrawAmountBox;
    @FindBy(xpath = "//button[text()='Withdraw']")
    private WebElement withdrawSubmitButton;
    @FindBy(xpath = "//span[text()='Transaction successful']")
    private WebElement withdrawConfirmation;
    @FindBy(xpath = "//button[@class='btn logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;

     public CustomerPOM(WebDriver d)
     {
         driver=d;
         PageFactory.initElements(driver,this);
     }
     public void customerPageVerify()
     {
         Assert.assertTrue(customerName.isDisplayed());
         System.out.println("Inside Customer Account : "+customerName.getText());
     }
    public void customerLogin(String cName) throws InterruptedException {
      Select select = new Select(customerDropdown);
     List<WebElement> customers= select.getOptions();
     for(WebElement customer:customers)
     {
      String name = customer.getText();
      if(name.equalsIgnoreCase(cName))
      {
       customer.click();;
      }
     }
     Thread.sleep(2000);
     loginButton.click();
     Thread.sleep(2000);
     Assert.assertTrue(customerName.isDisplayed());
     System.out.println("Sucessfully logged into account : "+ customerName.getText());
    }
    public void seeTransactins() throws InterruptedException {
  Assert.assertTrue(transactionButton.isDisplayed());
  transactionButton.click();;
  Thread.sleep(2000);
  Assert.assertTrue(transactionTable.isDisplayed());
  System.out.println("Transaction table is displayed with recent and previous history");
  backButton.click();
  Thread.sleep(2000);
    }
    public void depositeAmount(String amount) throws InterruptedException
    {
     Assert.assertTrue(depositButton.isDisplayed());
     depositButton.click();
     Thread.sleep(2000);
    Assert.assertTrue( depositeSection.isDisplayed());
    depositAmountBox.sendKeys(amount);
    depositeSubmitButton.click();
    Assert.assertTrue(depositeConfirmation.isDisplayed());
    System.out.println("Amount deposited with message : "+ depositeConfirmation.getText());

    }
    public void withdrawAmount(String amount) throws InterruptedException {
     Assert.assertTrue(withdrawalButton.isDisplayed());
    withdrawalButton.click();
     Thread.sleep(2000);
     Assert.assertTrue( withdrawalSection.isDisplayed());
     withdrawAmountBox.sendKeys(amount);
     withdrawSubmitButton.click();
     Assert.assertTrue(withdrawConfirmation.isDisplayed());
     Thread.sleep(2000);
     System.out.println("Amount deposited with message : "+ withdrawConfirmation.getText());
    }
    public void customerLogout() throws InterruptedException {
     Assert.assertTrue(logoutButton.isDisplayed());
     logoutButton.click();
     Thread.sleep(2000);
     Assert.assertTrue(homeButton.isDisplayed());
     homeButton.click();
     Thread.sleep(2000);
    }




}
