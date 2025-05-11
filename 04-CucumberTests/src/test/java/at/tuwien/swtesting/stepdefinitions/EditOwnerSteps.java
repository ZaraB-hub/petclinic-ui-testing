package at.tuwien.swtesting.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import at.tuwien.swtesting.pageobjects.*;

import static org.junit.jupiter.api.Assertions.*;

public class EditOwnerSteps {

    private WebDriver driver = Hooks.getDriver();
    private FindOwnerPage findOwnerPage;
    private OwnerPage ownerPage;
    private EditOwnerPage editOwnerPage;

    @Given("I am on the Find Owner page")
    public void i_am_on_the_find_owner_page() {
        findOwnerPage = new FindOwnerPage(driver);
        findOwnerPage.navigateToFindPage();
    }

    @When("I search for owner with last name {string}")
    public void i_search_for_owner_with_last_name(String lastName) {
        Object result = findOwnerPage.findOwner(lastName);
        if (result instanceof OwnerPage) {
            ownerPage = (OwnerPage) result;
        } else {
            throw new IllegalStateException("Expected to land on OwnerPage");
        }
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Edit Owner")) {
            editOwnerPage = ownerPage.clickEditButton();
        } else {
            throw new IllegalArgumentException("Unsupported button");
        }
    }

    @When("I update the owner form with city {string}")
    public void i_update_the_owner_form_with_city(String city) {
            editOwnerPage.fillCity( city);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_update_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Update Owner")) {
            ownerPage = editOwnerPage.clickUpdateOwnerButton();
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonName);
        }
    }

    @Then("the owner details should be displayed with name {string} and city {string}")
    public void the_owner_details_should_be_displayed_with_name_and_city(String expectedName, String expectedCity) {
        assertEquals(expectedName, ownerPage.getName());
        assertEquals(expectedCity, ownerPage.getCity());
    }
}
