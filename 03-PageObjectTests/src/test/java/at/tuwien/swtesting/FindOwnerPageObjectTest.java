package at.tuwien.swtesting;

import at.tuwien.swtesting.pageobjects.AddOwnerPage;
import at.tuwien.swtesting.pageobjects.FindOwnerPage;
import at.tuwien.swtesting.pageobjects.OwnerPage;
import at.tuwien.swtesting.pageobjects.OwnersPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindOwnerPageObjectTest {
    private static WebDriver driver;
    private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.getInstance(DRIVER_TYPE).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeEach
    public void waitForFindPage() {
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFindOwner() {
        FindOwnerPage findOwnerPage = new FindOwnerPage(driver);
        findOwnerPage.navigateToFindPage();
        Object result = findOwnerPage.findOwner("Franklin");

        if (result instanceof OwnerPage ownerPage) {
            assertEquals("George Franklin", ownerPage.getName());
        } else if(result instanceof OwnersPage ownersPage){
            assertEquals("Owners",ownersPage.getHeading());
        }else {
            Assertions.fail("Did not navigate to expected OwnerPage.");
        }
    }

    @Test
    public void testAllOwners() {
        FindOwnerPage findOwnerPage = new FindOwnerPage(driver);
        findOwnerPage.navigateToFindPage();
        OwnersPage ownersPage = findOwnerPage.clickFindOwnerButton();
        assertTrue(ownersPage.getHeading().contains("Owners"));

    }

    @Test
    public void testManyOwners() {
        FindOwnerPage findOwnerPage = new FindOwnerPage(driver);
        findOwnerPage.navigateToFindPage();
        Object result = findOwnerPage.findOwner("Davis");

        if (result instanceof OwnersPage ownersPage) {
            assertTrue(ownersPage.getHeading().contains("Owners"));
        } else {
            Assertions.fail("Did not navigate to expected OwnersPage.");
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
