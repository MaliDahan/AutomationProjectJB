package unitTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MainPage;
import pages.SignInPage;


public class MainUnitTest {
	public static void main(String[] args) {
		// init  web driver and open the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbt\\Documents\\MaliWorkSpace\\Selenium\\chromedriver_win32\\chromedriver.exe");   
		WebDriver driver =  new ChromeDriver(); 
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//initial Constructors
		SignInPage sip=new SignInPage(driver,wait);
		MainPage main=new MainPage(driver,wait);
		
		//Navigate To jpet store Sign in Page
		sip.NavigateToPage();
		
		//valid Login
		sip.EnterUserName("TestMali");
		sip.EnterPassword("123456789");
		sip.ClickLogInButton();
		
		// check if welcome message displayed
		System.out.println(main.GetWelcome());
		
		// check if sign out button displayed
		System.out.println(main.IsSignOut());
	
	}

}
