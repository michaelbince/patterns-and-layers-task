package steps;

import models.User;
import pages.LoginPage;

public class LoginStep extends TestStep {
    private LoginPage loginPage;
    private User user;

    public LoginStep(LoginPage loginPage, User user){
        this.loginPage = loginPage;
        this.user = user;
    }

    @Override
    protected void perform() {
        loginPage.login(user.name(), user.password());
    }
}
