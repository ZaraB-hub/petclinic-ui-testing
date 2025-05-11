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

public class AddOwnerTest {

    private static WebDriver driver;
    private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;
    private static String baseUrl="http://localhost:8080/";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.getInstance(DRIVER_TYPE).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
    public void testAddOwner() {
        driver.navigate().to(baseUrl+"owners/new");

        driver.findElement(By.id("firstName")).sendKeys("Zara");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("Bahtanovic");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Dresdner");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Wien");
        driver.findElement(By.id("telephone")).click();
        driver.findElement(By.id("telephone")).sendKeys("0123456789");
        driver.findElement(By.cssSelector(".btn")).click();

        assertEquals("New Owner Created",driver.findElement(By.id("success-message")).getText());

        assertEquals("Zara Bahtanovic",driver.findElement(By.cssSelector("b")).getText());
        assertEquals("Dresdner",driver.findElement(By.cssSelector("tr:nth-child(2) > td")).getText());
        assertEquals("Wien",driver.findElement(By.cssSelector("tr:nth-child(3) > td")).getText());
        assertEquals("0123456789",driver.findElement(By.cssSelector("tr:nth-child(4) > td")).getText());
        assertEquals("Owner Information",driver.findElement(By.cssSelector("h2")).getText());




    }




}
