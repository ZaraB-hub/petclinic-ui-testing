package at.tuwien.swtesting;

import at.tuwien.swtesting.pageobjects.EditOwnerPage;
import at.tuwien.swtesting.pageobjects.OwnerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditOwnerPageObjectTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void navigateToEditPage() {
        driver.get("http://localhost:8080/owners/1/edit");
    }

    @Test
    public void testEditOwnerCity() {
        EditOwnerPage editPage = new EditOwnerPage(driver);
        editPage.fillForm("George", "Franklin", "110 W. Liberty St.", "Vienna", "6085551023");
        OwnerPage ownerPage = editPage.clickUpdateOwnerButton();

        assertEquals("George Franklin", ownerPage.getName());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}
