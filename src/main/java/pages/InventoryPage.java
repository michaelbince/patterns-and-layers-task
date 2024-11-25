package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InventoryPage extends BasePage {
    private static final String NAME_IDENTIFIER_FOR_ITEM = ".inventory_item_name";
    public static final String PAGE_TITLE = "Swag Labs";

    @FindBy(css = ".app_logo")
    private WebElement logo;

    @FindBy(css = "span[data-test=\"title\"]")
    private WebElement productsSection;

    @FindBy(css = ".inventory_item")
    private List<WebElement> productItems;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartButton;

    public String getSectionTitle() {
        waitForTextAndReturnElement(logo, PAGE_TITLE);
        return waitForVisibilityOf(productsSection).getText();
    }

    public WebElement getProductElementByName(String productName){
        return productItems.stream()
                .filter(item -> item.findElement(By.cssSelector(NAME_IDENTIFIER_FOR_ITEM))
                        .getText()
                        .equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productName));
    }

    public void addProductToCart(String ProductName){
        WebElement productElement = getProductElementByName(ProductName);
        WebElement addToCartButton = productElement.findElement(By.cssSelector("button.btn_inventory"));
        waitForClickAbilityOf(addToCartButton).click();
    }

    public void GoToShoppingCart(){
        waitForVisibilityOf(shoppingCartButton).click();
    }
}
