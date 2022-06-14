package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PercentageCalcPage extends BasePage {
	
	
	
	// constants
	 private final static String URL="https://www.calculator.net/percent-calculator.html";
	 private final String TITLE_XPATH="//*[@id=\"content\"]/h1";
	
	 private final String FIELD1_ID="cpar1";
	 private final String FIELD2_ID="cpar2";
	 private final String CALC_BTN_XPATH="//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]";
	 private final String RESULT_CLASS_NAME="h2result";
	
	
	//Constructor
	public PercentageCalcPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait,URL);
		
	}
	
	// Methods
	
	public void NavigateToPage() {
		super.NavigateToPage(By.xpath(TITLE_XPATH));
	}
	public void EnterValueToField1(String value) {
		/*
		 * if(value != null) { WebElement field1 =
		 * _wait.until(ExpectedConditions.presenceOfElementLocated(By.id(FIELD1_ID)));
		 * field1.clear(); // empty the field from any current value
		 * field1.sendKeys(value); }
		 */
		
		super.FindAndEnterValue(By.id(FIELD1_ID), value);
		
	}
	public void EnterValueToField2(String value) {
		/*
		 * if(value != null) { WebElement field2 =
		 * _wait.until(ExpectedConditions.presenceOfElementLocated(By.id(FIELD2_ID)));
		 * field2.clear(); // empty the field from any current value
		 * field2.sendKeys(value); }
		 */
		
		super.FindAndEnterValue(By.id(FIELD2_ID), value);
	}
	
	public void ClickCalcButton() {
		super.FindAndClick(By.xpath(CALC_BTN_XPATH));
		
	}
	
	public String GetResult() {
		WebElement result = _wait.until(ExpectedConditions.presenceOfElementLocated(By.className(RESULT_CLASS_NAME)));
		String actualResult = result.getText();
		return actualResult;
	}


	
	
	
}
