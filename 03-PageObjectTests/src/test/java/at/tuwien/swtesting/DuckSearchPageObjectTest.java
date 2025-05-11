package at.tuwien.swtesting;

import at.tuwien.swtesting.pageobjects.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import java.util.concurrent.TimeUnit;

public class DuckSearchPageObjectTest {

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
	public void testSearch() throws InterruptedException {
		driver.get("https://duckduckgo.com/");
		
		SearchPage searchPage = new SearchPage(driver);
		ResultsPage resultsPage = searchPage.searchFor("testing");

		Thread.sleep(50000);
		assertEquals("testing at DuckDuckGo", resultsPage.getTitle());
	}


}
