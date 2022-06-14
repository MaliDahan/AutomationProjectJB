package unitTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.SignInPage;

public class SignInUnitTest {
	
	public static void main(String[] args) {
		// init  web driver and open the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbt\\Documents\\MaliWorkSpace\\Selenium\\chromedriver_win32\\chromedriver.exe");   
		WebDriver driver =  new ChromeDriver(); 
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//initial Constructor
		SignInPage page=new SignInPage(driver,wait);
		
		//Navigate To jpet store Sign in Page
		page.NavigateToPage();
		
		//insert invalid UserName and Password
		page.EnterUserName("MALI");
		page.EnterPassword("123456789");
		page.ClickLogInButton();
		
		// check if Error displayed
		System.out.println(page.GetError());
	}
	
}
	
	

	

