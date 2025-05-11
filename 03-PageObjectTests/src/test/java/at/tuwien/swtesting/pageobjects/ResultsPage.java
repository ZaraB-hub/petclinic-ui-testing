package at.tuwien.swtesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ResultsPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait until results are visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-layout")));
	}
	
	public String getTitle() {		
		return driver.getTitle();
	}
	
}