package at.tuwien.swtesting.pageobjects;

import io.cucumber.java.it.Ed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OwnerPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public OwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTitle() {
        return driver.getTitle();
    }

    @FindBy(tagName = "h2")
    private WebElement heading;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[1]/td")
    private WebElement name;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[2]/th")
    private WebElement address;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[3]/td")
    private WebElement city;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[4]/td")
    private WebElement telephone;

    @FindBy(linkText = "Edit Owner")
    private WebElement editButton;

    public EditOwnerPage clickEditButton() {
        editButton.click();
        return new EditOwnerPage(driver);
    }

    public String getName() {
        return name.getText();
    }

    public String getAddress () {
        return address.getText();
    }
    public String getCity () {
        return city.getText();
    }
    public String getTelephone() {
        return telephone.getText();
    }

    public String getHeading() {
        return heading.getText();
    }



}
