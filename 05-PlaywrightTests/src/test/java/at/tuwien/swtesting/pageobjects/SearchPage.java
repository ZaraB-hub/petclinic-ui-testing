package at.tuwien.swtesting.pageobjects;

import com.microsoft.playwright.*;

public class SearchPage {
    protected Page page;
    protected Locator searchField;

    public SearchPage(Page page) {
        this.page = page;
        this.searchField = page.locator("input[name='q']");
    }

    public ResultsPage searchFor(String searchText) {
        searchField.fill(searchText);
        searchField.press("Enter");
        return new ResultsPage(page);
    }
}
