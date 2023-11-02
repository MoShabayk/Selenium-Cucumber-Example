package hu.unideb.inf;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {

    @Then("the {string} message is shown")
    public void theErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getErrorMessage());
    }



    @Then("the user is directed to {string}")
    public void theURLIsDirectedToPAGE_URL(String PAGE_URL) {
        assertEquals(PAGE_URL,homePage.getPageUrl());
    }
}
