package at.tuwien.swtesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchPage {
	
	protected WebDriver driver;

	@FindBy(name = "q") WebElement searchField;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ResultsPage searchFor(String searchText) {
		searchField.clear();
		searchField.sendKeys(searchText);

		searchField.submit();
		return new ResultsPage(driver);
	}
	
}
