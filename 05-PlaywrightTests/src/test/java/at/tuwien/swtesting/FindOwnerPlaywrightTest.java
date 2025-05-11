package at.tuwien.swtesting;


import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import at.tuwien.swtesting.pageobjects.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindOwnerPlaywrightTest {

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
    public void testFindSingleOwner() {
        findOwnerPage.navigateToFindPage();
        findOwnerPage.enterLastName("Franklin");
        findOwnerPage.clickFindOwnerButton();

        OwnerPage ownerPage = new OwnerPage(page);
        assertEquals("George Franklin", ownerPage.getName());
    }

    @Test
    public void testFindAllOwners() {
        findOwnerPage.navigateToFindPage();
        findOwnerPage.enterLastName("");
        findOwnerPage.clickFindOwnerButton();

        OwnersPage ownersPage = new OwnersPage(page);
    }

    @Test
    public void testFindMultipleOwnersByPrefix() {
        findOwnerPage.navigateToFindPage();
        findOwnerPage.enterLastName("D");
        findOwnerPage.clickFindOwnerButton();

        OwnersPage ownersPage = new OwnersPage(page);

    }
}
