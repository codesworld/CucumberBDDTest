package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.WebDriverManager;
import io.cucumber.java.Before;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;


public class TestHooks {

    @Before
    public void setUp() {
        WebDriverManager.getDriver().manage().window().maximize();
        WebDriverManager.getDriver().get(ConfigReader.getProperty("baseUrl"));
        WebDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() ) {
           byte[] screenshot = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "img/png","Failed screenshot");
        }
        WebDriverManager.closeDriver();
    }
}

