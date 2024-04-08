package test.score.qa.setup;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json",
        "html:target/cucumber","rerun:target/rerun.txt"},
        features = "src/test/resources/features/TestScenarioAutomation.feature",
        glue = {"classpath:test.score.qa.setup", "classpath:test.score.qa.stepdefs"},
        tags = "@MyTests")

public class TestBaseRunner {
}
