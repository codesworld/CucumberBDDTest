package hooks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/html-failed-report.html"},
            features = "target/rerun.txt",
            glue = {"stepDefinitions", "hooks"}
    )
    public class FailedTestRunner {
    }


