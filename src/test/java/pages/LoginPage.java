package pages;

import pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Username field
    @FindBy(id = "loginusername")
    private WebElement usernameField;

    // Password field
    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    // Login button
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(css = "#login2")
    private WebElement loginBtn;

    // Enter username
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn() {
        loginBtn.click();
    }
    // Click login button
    public void clickLoginButton() {
        loginButton.click();
    }
}
