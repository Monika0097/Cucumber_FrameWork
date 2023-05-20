package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public static void initialization()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\monika bilung\\OneDrive\\Desktop\\Cucumber\\Chrome Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Browser is launched successfully");
    }
    public static void tearDown()
    {
        driver.quit();
        System.out.println("Browser Is Closed");
    }
}
