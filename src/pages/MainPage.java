package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{
	
	// constants
	private final static String URL="https://petstore.octoperf.com/actions/Catalog.action";
	private final String TITLE_XPATH="//*[@id=\"LogoContent\"]/a/img";
	private final String Welcome="//*[@id=\"WelcomeContent\"]";
	private final String SignOutButton="//*[@id=\"MenuContent\"]/a[2]";
	
	//Constructor
	public MainPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait, URL);
	}
	// Methods
		//navigate to jpet store main page
		public void NavigateToPage() {
			super.NavigateToPage(By.xpath(TITLE_XPATH));
		}
		//return welcome message with user name
		public String GetWelcome() {
			WebElement result = _wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Welcome)));
			String actualResult = result.getText();
			return actualResult;
		}
		//return true/false due to presence of sign out button
		public boolean IsSignOut() {
			WebElement SignOut =_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SignOutButton)));
			String IsSignOut=SignOut.getText();
			return (IsSignOut.equals("Sign Out")) ;
		}
}
