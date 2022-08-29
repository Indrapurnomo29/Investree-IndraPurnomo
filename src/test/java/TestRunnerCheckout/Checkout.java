package TestRunnerCheckout;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/checkout",
        glue = "Checkout",
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml",
                "pretty","json:target/cucumber.json"})
public class Checkout {
}
