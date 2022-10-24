package challenge.front.acceptancetests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(tags = "",
        plugin = {"pretty", "json:target/destination/cucumber.json"},
        features = "src/test/resources/features/",
        glue = "challenge.front.steps")
public class AcceptanceTestSuite {
}
