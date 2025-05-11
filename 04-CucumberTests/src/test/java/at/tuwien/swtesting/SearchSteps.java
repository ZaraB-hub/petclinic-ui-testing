package at.tuwien.swtesting;

import at.tuwien.swtesting.pageobjects.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import java.util.concurrent.TimeUnit;

public class SearchSteps {
	
	private static WebDriver driver;
	private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;
	// private static final DriverManagerType DRIVER_TYPE = DriverManagerType.FIREFOX;	
	
	private SearchPage searchPage;
	private ResultsPage resultsPage;
	
	@Before
	public void setUpBeforeClass() {
		WebDriverManager.getInstance(DRIVER_TYPE).setup(); 
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@After
	public void tearDownAfterClass() {
		driver.quit();
	}
	

	@Given("I am on the search page {string}")
	public void i_am_on_the_searchpage(String url) {
		driver.get(url);
		searchPage = new SearchPage(driver);
	}

	@When("I enter the search term {string}")
	public void i_enter_the_search_term(String searchTerm) {
		resultsPage = searchPage.searchFor(searchTerm);
	}

	@Then("I should be on the results page")
	public void i_should_be_on_the_results_page() {
		assertEquals("testing at DuckDuckGo", resultsPage.getTitle());
	}

}
