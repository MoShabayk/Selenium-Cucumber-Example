package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage {

    private WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

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

//    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
//    private WebElement checkouterrormessage;
//    public String getcheckouterrormessage() {
//        return checkouterrormessage.getText();
//    }

}
