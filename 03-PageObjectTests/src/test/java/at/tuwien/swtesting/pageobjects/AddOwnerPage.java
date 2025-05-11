package at.tuwien.swtesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOwnerPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AddOwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn")
    private WebElement addOwnerButton ;

    @FindBy(id="firstName")
    private WebElement firstNameField;
    @FindBy(id="lastName")
    private WebElement lastNameField;
    @FindBy(id="address")
    private WebElement addressField;
    @FindBy(id="city")
    private WebElement cityField;
    @FindBy(id="telephone")
    private WebElement telephoneField;

    public void fillForm(String firstName, String lastName, String address, String city, String telephone) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        telephoneField.sendKeys(telephone);
    }

    public OwnerPage clickAddOwnerButton() {
        addOwnerButton.click();
        return new OwnerPage(driver);
    }

    public void navigateTo() {
        driver.get("http://localhost:8080/owners/new");
    }

    public String getAddOwnerButtonText() {
    	return addOwnerButton.getText();
    }

}
