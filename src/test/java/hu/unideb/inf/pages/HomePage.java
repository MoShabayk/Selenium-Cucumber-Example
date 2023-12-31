package hu.unideb.inf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final WebDriver driver;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement errorMessage;
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_info_label.summary_total_label")
    private WebElement priceLabel;

    private static final Map<String, By> textFields = Map.of(
       "Username", By.id("user-name"),
       "Password", By.id("password"),
       "First Name", By.id("first-name"),
       "Last Name", By.id("last-name"),
       "Zip Code", By.id("postal-code")
    );

//    private static final Map<String, By> itemButtons = Map.of(
//       "Sauce Labs Backpack", By.id("add-to-cart-sauce-labs-backpack"),
//       "Sauce Labs Bike Light", By.id("add-to-cart-sauce-labs-bike-light"),
//       "Sauce Labs Bolt T-Shirt", By.id("add-to-cart-sauce-labs-bolt-t-shirt"),
//       "Sauce Labs Fleece Jacket", By.id("add-to-cart-sauce-labs-fleece-jacket"),
//       "Sauce Labs Onesie", By.id("add-to-cart-sauce-labs-onesie"),
//       "Test.allTheThings() T-Shirt (Red)", By.id("add-to-cart-test.allthethings()-t-shirt-(red)")
//    );

    private static final Map<String, By> navigationButtons = Map.of(
        "Login", By.id("login-button"),
        "Cart", By.className("shopping_cart_link"),
        "Checkout", By.id("checkout"),
        "Continue", By.id("continue"),
        "ResetAppState", By.id("reset_sidebar_link"),
        "Logout",By.id("logout_sidebar_link"),
        "About",By.id("about_sidebar_link"),
        "AllItems",By.id("inventory_sidebar_link"),
        "Sidebar",By.id("react-burger-menu-btn"),
        "Continue Shopping",By.id("continue-shopping")
    );

    public void refreshPage() {
        driver.navigate().refresh();
    }

    //    private static final Map<String, By> sidebarAnchors = Map.of(
//    "ResetAppState", By.id("reset_sidebar_link"),
//    "Logout",By.id("logout_sidebar_link"),
//    "About",By.id("about_sidebar_link"),
//    "AllItems",By.id("inventory_sidebar_link")
//    );
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }
    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    private WebElement checkouterrormessage;
    public String getcheckouterrormessage() {
        return checkouterrormessage.getText();
    }

    public String getTotal() {
        return priceLabel.getText();
    }
    public String getPageUrl(){return driver.getCurrentUrl();}

}
