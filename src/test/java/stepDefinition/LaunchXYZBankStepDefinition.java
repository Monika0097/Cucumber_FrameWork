package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.Base;
import pom.HomePOM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LaunchXYZBankStepDefinition  extends Base {
    public static HomePOM home;

    @Given("Launch chrome browser")
    public void launch_chrome_browser()
    {
        Base.initialization();
//             System.setProperty("webdriver.chrome.driver","C:\\Users\\monika bilung\\OneDrive\\Desktop\\Cucumber\\Chrome Driver\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
//            driver.manage().window().maximize();
//           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//            System.out.println("Browser is launched successfully");

    }
    @When("URL of XYZBank is provided")
    public void url_of_xyz_bank_is_provided() throws InterruptedException {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(6000);
    }
    @Then("Validate the process of launching XYZBank application")
    public void validate_the_process_of_launching_xyz_bank_application() throws InterruptedException {
      home= new HomePOM(driver); ;
     home.verifyLaunchApplication();
     home.clickManagerLogin();

    }
    @And("Close the browser")
    public void close_the_browser() {
        driver.quit();
        System.out.println("Browser is closed successfully");
    }
}
