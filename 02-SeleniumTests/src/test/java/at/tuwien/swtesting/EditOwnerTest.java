package at.tuwien.swtesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EditOwnerTest {

    private static WebDriver driver;
    private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;
    private static String baseUrl="http://localhost:8080/";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.getInstance(DRIVER_TYPE).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


    }

    @BeforeEach
    public void openPage() {
        driver.get(baseUrl);
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testEditOwner() {
        driver.navigate().to(baseUrl+"owners/find");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("black");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

        driver.findElement(By.linkText("Edit Owner")).click();

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Wien");
        driver.findElement(By.className("btn")).click();
        assertEquals("Owner Values Updated",driver.findElement(By.id("success-message")).getText());



    }


}
