package at.tuwien.swtesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OwnersPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public OwnersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    private WebElement heading;

    public String getHeading() {
        return heading.getText();
    }

    public List<String> getAllOwnerNames() {
        List<WebElement> ownerNameCells = driver.findElements(By.cssSelector("table tbody tr td:first-child a"));
        return ownerNameCells.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getAllOwnerLastNames() {
        return getAllOwnerNames().stream()
                .map(fullName -> fullName.split(" ")[1]) // assumes "First Last"
                .collect(Collectors.toList());
    }

}