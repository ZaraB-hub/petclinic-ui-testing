package at.tuwien.swtesting.pageobjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.stream.Collectors;

public class OwnersPage {
    private final Page page;

    public OwnersPage(Page page) {
        this.page = page;
    }

    public String getHeading() {
        return page.textContent("h2");
    }


}
