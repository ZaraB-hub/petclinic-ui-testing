package at.tuwien.swtesting.pageobjects;


import com.microsoft.playwright.Page;

public class EditOwnerPage {
    private final Page page;

    public EditOwnerPage(Page page) {
        this.page = page;
    }

    public void fillForm(String firstName, String lastName, String address, String city, String telephone) {
        page.fill("#firstName", firstName);
        page.fill("#lastName", lastName);
        page.fill("#address", address);
        page.fill("#city", city);
        page.fill("#telephone", telephone);
    }

    public void fillCity(String city) {
        page.fill("#city", city);
    }

    public void clickUpdateOwnerButton() {
        page.click(".btn");
    }
}
