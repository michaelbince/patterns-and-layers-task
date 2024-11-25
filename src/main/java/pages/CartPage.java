package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement subtitle;

    @FindBy(css = ".cart_item")
    private List<WebElement> itemsAdded;

    public boolean isItemOnTheCart(String itemName) {
        return itemsAdded.stream()
                .anyMatch(item -> itemName.equalsIgnoreCase(item.findElement(By.cssSelector("div[data-test='inventory-item-name']")).getText()));
    }

}
