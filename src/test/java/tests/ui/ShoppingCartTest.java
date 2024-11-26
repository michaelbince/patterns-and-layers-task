package tests.ui;

import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import steps.AddProductToCartStep;
import steps.LoginStep;
import steps.TestStep;

public class ShoppingCartTest extends BaseTest {

    @DataProvider(name = "userDataProvider", parallel = true)
    public Object[][] provideUserData(){
        return new Object[][] {
                {"standard_user", "secret_sauce", "Sauce Labs Backpack"},
                {"visual_user", "secret_sauce", "Sauce Labs Backpack"}
        };
    }

    @Test(dataProvider = "userDataProvider",
            description = "Verify item can be added to the shopping cart")
    public void verifyItemAddedToTheCartSuccessfully(String userName, String password, String product) {
        User user = new UserBuilder()
                .withName(userName)
                .withPassword(password)
                .build();

        TestStep loginStep = new LoginStep(new LoginPage(), user);
        TestStep addProductToCartStep = new AddProductToCartStep(new InventoryPage(), product);
        CartPage cartPage = new CartPage();

        loginStep.setNextStep(addProductToCartStep).execute();


        Assert.assertTrue(cartPage.isItemOnTheCart(product), "The product: "+ product +" is not on the cart");
    }
}
