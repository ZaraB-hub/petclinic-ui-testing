package at.tuwien.swtesting;

import at.tuwien.swtesting.pageobjects.*;

import com.microsoft.playwright.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DuckSearchPlaywrightTest {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterAll
    public static void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void testSearch() {
        page.navigate("https://duckduckgo.com/");

        SearchPage searchPage = new SearchPage(page);
        ResultsPage resultsPage = searchPage.searchFor("testing");

		assertEquals("testing at DuckDuckGo", resultsPage.getTitle());
    }
}
