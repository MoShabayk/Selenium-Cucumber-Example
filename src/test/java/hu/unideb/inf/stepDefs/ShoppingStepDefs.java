package hu.unideb.inf.stepDefs;

import hu.unideb.inf.pages.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ShoppingStepDefs extends AbstractStepDefs{

    @Given("I have the {string} and {string} in my shopping cart")
    public void addItemsToCart(String item1, String item2) {
        inventoryPage.addItemToCart(item1);
        inventoryPage.addItemToCart(item2);
    }

//    @Then("I should have two items in my shopping cart")
//    public void verifyNumberOfItemsInCart() {
//        assert inventoryPage.getNumberOfItemsInCart() == 2;
//    }

    @Then("I should have {int} items in my shopping cart")
    public void verifyNumberOfItems(int number) {
        assertEquals(inventoryPage.getNumberOfItemsInCart(), number);
    }
    @Given("I remove the {string} from the shopping cart")
    public void removeItem2FromCart(String item) {
        inventoryPage.removeItemFromCart(item);
    }

    @Given("I add the {string} to the shopping cart")
    public void addItem1ToCart(String item) {
        inventoryPage.addItemToCart(item);
    }

    @Given("I am logged in to Saucedemo")
    public void verifyUserLogin() {
        // Implement login verification logic
    }

    @Given("I proceed to checkout")
    public void initiateCheckout() {
        // Implement checkout initiation logic
    }

    @Then("I should successfully complete the checkout process")
    public void verifySuccessfulCheckout() {
        // Implement checkout success verification logic
    }

    @Given("the {string} anchor is clicked")
    public void theResetAppStateAnchorIsClicked() {
    }
    @Then("the checkout {string} message is shown")
    public void theCheckoutErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getcheckouterrormessage());
    }

//    @Then("I should have zero item in my shopping cart")
//    public void iShouldHaveZeroItemInMyShoppingCart() {
//    }
}