package hu.unideb.inf.pages;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.LowerCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }


    public int getNumberOfItemsInCart() {
        String cartBadgeText = driver.findElement(By.id("shopping-cart-badge")).getText();
        if (cartBadgeText.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(cartBadgeText);
        }
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

}
