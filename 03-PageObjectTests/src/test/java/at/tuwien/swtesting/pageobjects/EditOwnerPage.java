package at.tuwien.swtesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditOwnerPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public EditOwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn")
    private WebElement updateOwnerButton ;

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
        firstNameField.clear();
        firstNameField.sendKeys(firstName);

        lastNameField.clear();
        lastNameField.sendKeys(lastName);

        addressField.clear();
        addressField.sendKeys(address);

        cityField.clear();
        cityField.sendKeys(city);

        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }


    public OwnerPage clickUpdateOwnerButton() {
        updateOwnerButton.click();
        return new OwnerPage(driver);
    }


}
