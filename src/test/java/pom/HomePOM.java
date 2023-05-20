package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HomePOM {

    private WebDriver driver;
    @FindBy(xpath="//button[@class='btn home']")
    private WebElement homeButton;
    @FindBy(xpath="//strong[text()='XYZ Bank']")
    private WebElement pageLogo;
    @FindBy(xpath="(//button[@class='btn btn-primary btn-lg'])[1]")
   private  WebElement customerLoginButton;
    @FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    private WebElement managerLoginButton;

    public HomePOM(WebDriver d)
    {
        driver=d;
       PageFactory.initElements(driver,this);
    }
    public void verifyLaunchApplication()
    {
        System.out.println("Page Logo displayed as : "+ pageLogo.getText());
        Assert.assertTrue(pageLogo.isDisplayed());
        System.out.println("Application is launched successfully");
    }
    public void clickManagerLogin() throws InterruptedException
    {
     managerLoginButton.click();
     Thread.sleep(3000);
    }
    public void clickCustomerLogin() throws InterruptedException {
        Assert.assertTrue(customerLoginButton.isDisplayed());
        customerLoginButton.click();
        Thread.sleep(2000);
    }
    public void clickHome()
    {
        Assert.assertTrue(homeButton.isDisplayed());
        homeButton.click();
        Assert.assertTrue(pageLogo.isDisplayed());
        System.out.println("Navigated to Home page after clicking on Home button");
    }


}
