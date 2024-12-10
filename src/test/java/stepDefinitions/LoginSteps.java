package stepDefinitions;

import org.openqa.selenium.Alert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static utils.WebDriverManager.getDriver;

public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage = new HomePage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        //WebDriverManager.getDriver().get("https://www.demoblaze.com/");
        loginPage = new LoginPage();
        loginPage.clickLoginBtn();
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username)
    {
        if( username.contains("testuser")) {
            loginPage.enterUsername(ConfigReader.getProperty("username"));
        }else {
            loginPage.enterUsername(username) ;
        }
    }

    @When("I enter the password {string}")
    public void iEnterThePassword(String password)
    {
        if(password.contains("testpassword")) {
            loginPage.enterPassword(ConfigReader.getProperty("password"));
        }else {
            loginPage.enterPassword(password)  ;
        }
    }

    @When("I click the login button")
    public void iClickTheLoginButton() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(3000);
    }

    @Then("I should see the {string}")
    public void iShouldSeeTheMessage(String message) {

        if(message.contains("Wrong")){
            Alert alertHandler = getDriver().switchTo().alert();
            String actualMessage = alertHandler.getText();
            Assert.assertTrue("Alert message is not as expected!", actualMessage.contains(message));

            alertHandler.accept();
        }else if (message.contains("Please")){
            Alert alertHandler = getDriver().switchTo().alert();
            String actualMessage = alertHandler.getText();
            Assert.assertTrue(actualMessage.contains(message));

            alertHandler.accept();
        } else {
            String welcomeMessage =  homePage.getWelcomeMessageTexts();
            System.out.println(welcomeMessage);
            Assert.assertTrue(welcomeMessage.contains(message));
        }
    }
}
