package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MainPage;
import pages.SignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


//automation test for sign in page
public class SignInTests {
	
	// local variables
		WebDriver driver;
		WebDriverWait wait;
		SignInPage signInPage;
		MainPage mainPage;
		
	//check login with valid user name and password 
	  @Test
	  public void ValidLogin() {
		  try {
			  //define soft assert variable
			  	SoftAssert sa = new SoftAssert();
			  	
			  	//test steps
			  	signInPage.EnterUserName("TestMali");
				signInPage.EnterPassword("123456789");
				signInPage.ClickLogInButton();
				
				//check for error message displayed
				String welcomeMessage =mainPage.GetWelcome();
				sa.assertEquals(welcomeMessage,"Welcome Test!");
				
				//check for sign out button displayed
				sa.assertEquals(mainPage.IsSignOut(),true);
				
				//check validation of all expected result 
				sa.assertAll();
		//if try was failed
		  } catch(Exception e) {
			  System.out.println("Cannot execute SignOut script due to " + e.getMessage());
		  }
	  }
	//check login with invalid user name or password
	  @Test(dataProvider = "InValidDataForSignIn")
	  public void InValidLogin(String username, String password, String expected) {
		  try {
			  
			  	SoftAssert sa = new SoftAssert();
			  	signInPage.EnterUserName(username);
				signInPage.EnterPassword(password);
				signInPage.ClickLogInButton();
				
				//check for error message displayed
				String Error=signInPage.GetError();
				sa.assertEquals(Error, expected);
				
				//check validation of all expected result 
				sa.assertAll();
			//if try was failed
		  } catch(Exception e) {
			  System.out.println("Cannot execute SignOut script due to " + e.getMessage());
		  }
	  }
	  //navigate to jpet store - sign in page
	  @BeforeMethod
	  public void beforeMethod() {
		  try {
			  	signInPage.NavigateToPage(); 
			  //if try was failed
		  		} catch(Exception e) {
			  System.out.println("Cannot navigate to page due to" + e.getMessage());
		  		}
		  
		  
	  }
	
	  @AfterMethod
	  public void afterMethod() {
		// do nothing
	  }
	
	//provide invalid data for invalid login test
	  @DataProvider(name="InValidDataForSignIn")
	  public Object[][] createDataForInvalidLogin() {
	    return new Object[][] {
	    	{"TestMali", "1234","Invalid username or password. Signon failed."},
	    	{"Test", "123456789","Invalid username or password. Signon failed."}
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		// init local variables 
		  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbt\\Documents\\MaliWorkSpace\\Selenium\\chromedriver_win32\\chromedriver.exe");   
			 driver =  new ChromeDriver(); 
			 wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			 signInPage= new SignInPage(driver, wait);
			 mainPage= new MainPage(driver, wait);
	  }
	//quit from browser
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
