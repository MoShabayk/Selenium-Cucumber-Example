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
    @FindBy(css = "#shopping_cart_container > a > span")
    private WebElement cartNumber;

    public int getNumberOfItemsInCart() {
            return Integer.parseInt(cartNumber.getText());
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

}
