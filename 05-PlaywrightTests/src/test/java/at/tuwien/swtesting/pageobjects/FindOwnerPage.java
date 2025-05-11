package at.tuwien.swtesting.pageobjects;



import com.microsoft.playwright.Page;

import java.time.Duration;

public class FindOwnerPage {
    private final Page page;

    public FindOwnerPage(Page page) {
        this.page = page;
    }

    public void navigateToFindPage() {
        page.navigate("http://localhost:8080/owners/find");
    }

    public void enterLastName(String lastName) {
        page.fill("input[name='lastName']", lastName);
    }

    public void clickFindOwnerButton() {
        page.click(".btn"); // Make more specific if needed
    }

    public void clickAddOwnerButton() {
        page.click("text=Add Owner");
    }

    public String getFindOwnerButtonText() {
        return page.textContent(".btn");
    }

    public String getAddOwnerButtonText() {
        return page.textContent("text=Add Owner");
    }

    public String getLastNameValue() {
        return page.inputValue("input[name='lastName']");
    }
}
