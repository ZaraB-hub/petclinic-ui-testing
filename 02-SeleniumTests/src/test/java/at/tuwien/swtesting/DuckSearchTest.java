package at.tuwien.swtesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class DuckSearchTest {

	private static WebDriver driver;
	private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;
	// private static final DriverManagerType DRIVER_TYPE = DriverManagerType.FIREFOX;

	@BeforeAll
	public static void setUp() {
		WebDriverManager.getInstance(DRIVER_TYPE).setup();
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

    @AfterAll
    public static void tearDown() {
		driver.quit();
	}

	@Test
	public void testSearch() {

		driver.get("https://duckduckgo.com/");

		WebElement searchField = driver.findElement(By.name("q"));
		searchField.clear();
		searchField.sendKeys("testing");
		searchField.submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("testing"));

		assertEquals("testing at DuckDuckGo", driver.getTitle());
	}


}
