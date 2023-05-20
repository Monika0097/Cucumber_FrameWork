package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\monika bilung\\OneDrive\\Desktop\\Cucumber\\ManagerFuctionality.feature",
        glue="C:\\Users\\monika bilung\\OneDrive\\Desktop\\Cucumber\\src\\test\\java\\stepDefinition",
        dryRun = true,
        plugin= {"pretty"}
)
public class TestRunner {
}
