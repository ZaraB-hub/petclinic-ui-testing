package at.tuwien.swtesting;
import at.tuwien.swtesting.pageobjects.*;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EditOwnerPlaywrightTest {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;
    static FindOwnerPage findOwnerPage;

    @BeforeAll
    static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        findOwnerPage = new FindOwnerPage(page);
    }

    @AfterAll
    static void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void testEditOwnerCity() {
        findOwnerPage.navigateToFindPage();
        findOwnerPage.enterLastName("Franklin");
        findOwnerPage.clickFindOwnerButton();

        OwnerPage ownerPage = new OwnerPage(page);
        assertEquals("George Franklin", ownerPage.getName());

        ownerPage.clickEditOwner();

        EditOwnerPage editOwnerPage = new EditOwnerPage(page);
        editOwnerPage.fillCity("Vienna");
        editOwnerPage.clickUpdateOwnerButton();

        OwnerPage updatedOwnerPage = new OwnerPage(page);
        assertEquals("Vienna", updatedOwnerPage.getCity());
    }
}