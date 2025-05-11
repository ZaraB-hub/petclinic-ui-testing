package at.tuwien.swtesting;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import at.tuwien.swtesting.pageobjects.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOwnerPlaywrightTest {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;
    static AddOwnerPage addOwnerPage;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        addOwnerPage = new AddOwnerPage(page);
    }

    @AfterAll
    public static void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void testAddOwner() {
        addOwnerPage.navigateTo();
        addOwnerPage.fillForm("Zara", "Bahtanovic", "Dresdner", "Wien", "0123456789");
        addOwnerPage.submitForm();

        String fullName = page.textContent("table tr:first-of-type td b");
        String city = page.textContent("table tr:nth-child(3) td");

        assertEquals("Zara Bahtanovic", fullName);
        assertEquals("Wien", city);
    }
}
