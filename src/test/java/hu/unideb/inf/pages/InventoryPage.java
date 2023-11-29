package hu.unideb.inf.pages;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.LowerCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(css = "#shopping_cart_container > a.shopping_cart_link > span.shopping_cart_badge")
    private WebElement cartNumber;
    public void addItemToCart(String item) {
        String formattedString = item.toLowerCase();
        formattedString = formattedString.replace(" ", "-");
        WebElement addButton = driver.findElement(By.id( "add-to-cart-"+formattedString));
        addButton.click();
//        driver.findElement(itemButtons.get(item)).click();
    }
    public void removeItemFromCart(String itemName) {
        String formattedString = itemName.toLowerCase();
        formattedString = formattedString.replace(" ", "-");
        WebElement removeButton = driver.findElement(By.id( "remove-"+formattedString));
        removeButton.click();
    }
    public int getNumberOfItemsInCart() {
        return driver.findElements(By.className("cart_item")).size();
    }


    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

}
