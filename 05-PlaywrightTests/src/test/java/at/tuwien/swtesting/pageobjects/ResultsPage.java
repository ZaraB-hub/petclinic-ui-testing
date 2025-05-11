package at.tuwien.swtesting.pageobjects;

import com.microsoft.playwright.*;

public class ResultsPage {
    protected Page page;

    public ResultsPage(Page page) {
        this.page = page;
        // Wait until results are visible
        page.waitForSelector("#react-layout");
    }

    public String getTitle() {
        return page.title();
    }
}
