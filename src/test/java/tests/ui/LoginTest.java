package tests.ui;

import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import steps.LoginStep;
import steps.TestStep;

public class LoginTest  extends BaseTest {
    public static final String COMMON_PASSWORD = "secret_sauce";
    public static final String PRODUCTS_SECTION_TITLE = "Products";

    @DataProvider(name = "userDataProvider", parallel = true)
    public Object[][] provideUserData(){
        return new Object[][] {
            {"standard_user", COMMON_PASSWORD},
            {"problem_user", COMMON_PASSWORD},
            {"performance_glitch_user", COMMON_PASSWORD},
            {"error_user", COMMON_PASSWORD},
            {"visual_user", COMMON_PASSWORD}
        };
    }

    @Test(dataProvider = "userDataProvider",
          description = "Verify Login functionality with multiple users")
    public void verifySuccessfullyLogin(String userName, String password) {
        User user = new UserBuilder()
                        .withName(userName)
                        .withPassword(password)
                        .build();

        TestStep loginStep = new LoginStep(new LoginPage(), user);
        InventoryPage inventoryPage = new InventoryPage();

        loginStep.execute();

        Assert.assertEquals(inventoryPage.getSectionTitle(), PRODUCTS_SECTION_TITLE);
    }
}
