package hu.unideb.inf.stepDefs;

import hu.unideb.inf.pages.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


public class ShoppingStepDefs extends AbstractStepDefs{

    @Given("I have the {string} and {string} in my shopping cart")
    public void addItemsToCart(String item1, String item2) {
        homePage.addItemToCart(item1);
        homePage.addItemToCart(item2);
    }

//    @Then("I should have two items in my shopping cart")
//    public void verifyNumberOfItemsInCart() {
//        assert inventoryPage.getNumberOfItemsInCart() == 2;
//    }

    @Then("I should have {int} items in my shopping cart")
    public void verifyNumberOfItemsAfterRemoval(int number) {
        assert inventoryPage.getNumberOfItemsInCart() == number;
    }
    @Given("I remove the {string} from the shopping cart")
    public void removeItem2FromCart(String item) {
        homePage.removeItemFromCart(item);
    }

    @Given("I add the {string} to the shopping cart")
    public void addItem1ToCart(String item) {
        homePage.addItemToCart(item);
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

//    @Then("I should have zero item in my shopping cart")
//    public void iShouldHaveZeroItemInMyShoppingCart() {
//    }
}