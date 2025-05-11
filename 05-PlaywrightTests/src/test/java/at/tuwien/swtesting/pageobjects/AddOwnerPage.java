package at.tuwien.swtesting.pageobjects;

import com.microsoft.playwright.Page;

public class AddOwnerPage {
    private final Page page;

    public AddOwnerPage(Page page) {
        this.page = page;
    }

    public void navigateTo() {
        page.navigate("http://localhost:8080/owners/new");
    }

    public void fillForm(String firstName, String lastName, String address, String city, String telephone) {
        page.fill("#firstName", firstName);
        page.fill("#lastName", lastName);
        page.fill("#address", address);
        page.fill("#city", city);
        page.fill("#telephone", telephone);
    }

    public void submitForm() {
        page.click(".btn");
    }
}
