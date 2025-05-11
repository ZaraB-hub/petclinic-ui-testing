//package at.tuwien.swtesting.stepdefinitions;
//
//import at.tuwien.swtesting.stepdefinitions.Hooks;
//import at.tuwien.swtesting.pageobjects.*;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AddOwnerSteps {
//
//    private WebDriver driver = Hooks.getDriver();
//    private FindOwnerPage findOwnerPage;
//    private AddOwnerPage addOwnerPage;
//    private OwnerPage ownerPage;
//
//    @Given("I am on the Find Owner page")
//    public void i_am_on_the_find_owner_page() {
//        findOwnerPage = new FindOwnerPage(driver);
//        findOwnerPage.navigateToFindPage();
//    }
//
//    @When("I click the {string} button")
//    public void i_click_the_button(String buttonName) {
//        if (findOwnerPage.getAddOwnerButtonText().equalsIgnoreCase(buttonName)) {
//            addOwnerPage=findOwnerPage.clickAddOwnerButton();
//        } else {
//            throw new IllegalArgumentException("Unsupported button: " + buttonName);
//        }
//    }
//
//    @When("I fill in the owner form with first name {string}, last name {string}, address {string}, city {string}, and telephone {string}")
//    public void i_fill_in_owner_form(String first, String last, String address, String city, String phone) {
//        addOwnerPage.fillForm(first, last, address, city, phone);
//    }
//
//    @When("I submit the form")
//    public void i_submit_the_form() {
//        ownerPage = addOwnerPage.clickAddOwnerButton();
//    }
//
//    @Then("the owner details should be displayed with name {string}")
//    public void the_owner_details_should_be_displayed(String expectedName) {
//        assertEquals(expectedName, ownerPage.getName());
//    }
//}
