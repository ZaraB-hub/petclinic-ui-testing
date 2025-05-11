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

public class FindOwnerTest {

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
    public void testFindOwner() {
        driver.navigate().to(baseUrl+"owners/find");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("black");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

        assertEquals("Jeff Black",driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText());
        assertEquals("Owner Information",driver.findElement(By.tagName("h2")).getText());

    }


}
