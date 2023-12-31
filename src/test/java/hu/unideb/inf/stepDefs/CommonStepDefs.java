package hu.unideb.inf.stepDefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefs extends AbstractStepDefs {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @Given("the {string} field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
        homePage.fillOutField(field, text);
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickButton(button);
    }

    @AfterAll
    public static void cleanUp() {
        homePage.closePage();
    }

    @And("the page is refreshed")
    public void thePageIsRefreshed() {
        homePage.refreshPage();
    }
}
