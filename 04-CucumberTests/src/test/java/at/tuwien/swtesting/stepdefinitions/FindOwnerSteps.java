//package at.tuwien.swtesting.stepdefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import at.tuwien.swtesting.pageobjects.*;
//
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class FindOwnerSteps {
//
//    private WebDriver driver = Hooks.getDriver();
//    private FindOwnerPage findOwnerPage;
//    private OwnerPage ownerPage;
//    private OwnersPage ownersPage;
//
//    @Given("I am on the Find Owner page")
//    public void i_am_on_the_find_owner_page() {
//        findOwnerPage = new FindOwnerPage(driver);
//        findOwnerPage.navigateToFindPage();
//    }
//
//    @When("I search for owner with last name {string}")
//    public void i_search_for_owner_with_last_name(String lastName) {
//        Object result = findOwnerPage.findOwner(lastName);
//
//        if (result instanceof OwnerPage) {
//            ownerPage = (OwnerPage) result;
//        } else {
//            ownersPage = (OwnersPage) result;
//        }
//    }
//
//    @Then("the owner details should be displayed with name {string}")
//    public void the_owner_details_should_be_displayed_with_name(String expectedName) {
//        assertNotNull(ownerPage);
//        assertEquals(expectedName, ownerPage.getName());
//    }
//
//    @Then("I should see a list of owners whose last name start with {string}")
//    public void i_should_see_a_list_of_owners_whose_last_name_start_with(String prefix) {
//        assertNotNull(ownersPage);
//        assertNotEquals("o",prefix);
////        List<String> lastNames = ownersPage.getAllOwnerLastNames();
////        assertTrue(lastNames.stream().allMatch(name -> name.toLowerCase().startsWith(prefix.toLowerCase())));
//    }
////
//    @When("I click the {string} button")
//    public void i_click_the_button(String button) {
//        if (button.equalsIgnoreCase("Find Owner")) {
//            ownersPage = findOwnerPage.clickFindOwnerButton();
//        } else {
//            throw new IllegalArgumentException("Unsupported button: " + button);
//        }
//    }
//
//    @Then("I should see a list of all owners")
//    public void i_should_see_a_list_of_all_owners() {
//        assertNotNull(ownersPage);
////        assertTrue(ownersPage.getAllOwnerNames().size() > 0, "Owner list should not be empty");
//    }
//}
