package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/// this is a common page 
public abstract class BasePage {
	protected WebDriver _driver;
	protected WebDriverWait _wait;
	private String _url;
	
	//Constructor
	public BasePage(WebDriver driver, WebDriverWait wait, String url) {
		super();
		_driver = driver;
		_wait = wait;
		_url=url;
	}
	// methods
	protected void NavigateToPage(By by) {
		_driver.get(_url);
		
		// check if any element is displayed
		WebElement element = _wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	
	protected void FindAndEnterValue(By by, String value) {
		if(value != null) {
			WebElement field = _wait.until(ExpectedConditions.presenceOfElementLocated(by));
			field.clear(); // empty the field from any current value
			field.sendKeys(value);
		}
	}
	protected void FindAndClick(By by) {
		
			WebElement btn = _wait.until(ExpectedConditions.elementToBeClickable(by));
			btn.click();
		
	}
}
