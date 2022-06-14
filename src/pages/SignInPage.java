package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage {
	
	// constants
	 private final static String URL="https://petstore.octoperf.com/actions/Account.action;jsessionid=9F507F9DBA41414801A3B8BCCFB86C5A?signonForm=";
	 private final String TITLE_XPATH="//*[@id=\"LogoContent\"]/a/img";
	 private final String UserNameField="username";
	 private final String PasswordField="password";
	 private final String LogInButton="signon";
	 private final String Error="//*[@id=\"Content\"]/ul/li";
	
	 //Constructor
	public SignInPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait, URL);
		
	}
	
	// Methods
	public void NavigateToPage() {
		super.NavigateToPage(By.xpath(TITLE_XPATH));
	}
	
	public void EnterUserName(String value) {
		super.FindAndEnterValue(By.name(UserNameField), value);
	}
	
	public void EnterPassword(String value) {
		super.FindAndEnterValue(By.name(PasswordField), value);
	}
	
	public void ClickLogInButton() {
		super.FindAndClick(By.name(LogInButton));	
	}
	
	public String GetError() {
		WebElement result = _wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Error)));
		String actualResult = result.getText();
		return actualResult;
	}

}
