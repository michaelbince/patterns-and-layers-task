package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void login(String userName, String password) {
        waitForVisibilityOf(userNameField).sendKeys(userName);
        waitForVisibilityOf(passwordField).sendKeys(password);
        waitForClickAbilityOf(loginButton).click();
    }
}
