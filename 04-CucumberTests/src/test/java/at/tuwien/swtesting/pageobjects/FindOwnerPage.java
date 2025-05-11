package at.tuwien.swtesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindOwnerPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public FindOwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(className ="btn")
    private WebElement findOwner;

    @FindBy(linkText = "Add Owner")
    private WebElement addOwner;

    public Object findOwner(String lastName) {
        this.lastName.sendKeys(lastName);
        this.findOwner.click();

        String currentUrl = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if (currentUrl.matches(".*?/owners/\\d+$")) {
            return new OwnerPage(driver);
        } else {
            return new OwnersPage(driver);
        }
    }


    public OwnersPage clickFindOwnerButton() {
        findOwner.click();
        return new OwnersPage(driver);
    }

    public AddOwnerPage clickAddOwnerButton() {
        addOwner.click();
        return new AddOwnerPage(driver);
    }

    public String getLastName() {
        return lastName.getAttribute("value");
    }

    public String getFindOwnerButtonText() {
        return findOwner.getText();
    }

    public String getAddOwnerButtonText() {
        return addOwner.getText();
    }

    public void navigateToFindPage(){
        driver.get("http://localhost:8080/owners/find");
    }

}

