package steps;

import pages.InventoryPage;

public class AddProductToCartStep extends TestStep {
    private final InventoryPage inventoryPage;
    private final String productToBeAdded;

    public AddProductToCartStep(InventoryPage inventoryPage, String productToBeAdded){
        this.inventoryPage = inventoryPage;
        this.productToBeAdded = productToBeAdded;
    }
    @Override
    protected void perform() {
        inventoryPage.addProductToCart(productToBeAdded);
        inventoryPage.GoToShoppingCart();
    }
}
