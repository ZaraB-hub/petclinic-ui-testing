package at.tuwien.swtesting;

import at.tuwien.swtesting.pageobjects.AddOwnerPage;
import at.tuwien.swtesting.pageobjects.OwnerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOwnerPageObjectTest {

    private static WebDriver driver;
    private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;


    @BeforeAll
    public static void setUp() {
        WebDriverManager.getInstance(DRIVER_TYPE).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeEach
    public void navigateToAddOwnerPage() {
        AddOwnerPage addOwnerPage = new AddOwnerPage(driver);
        addOwnerPage.navigateTo();
    }

    @Test
    public void testAddOwner () throws InterruptedException {
        AddOwnerPage addOwnerPage = new AddOwnerPage(driver);
        addOwnerPage.fillForm("Zara", "Bahtanovic", "Dresdner", "Wien", "0123456789");
        OwnerPage ownerPage = addOwnerPage.clickAddOwnerButton();
        assertEquals("Zara Bahtanovic", ownerPage.getName());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}
