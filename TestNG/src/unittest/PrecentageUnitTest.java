package unittest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PercentageCalcPage;

public class PrecentageUnitTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbt\\Documents\\549147\\Selenium\\chromedriver_win32\\chromedriver.exe");   
		WebDriver driver =  new ChromeDriver(); 
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		PercentageCalcPage page = new PercentageCalcPage(driver, wait);
		page.NavigateToPage();
		page.EnterValueToField1("10");
		page.EnterValueToField2("100");
		page.ClickCalcButton();
	
		System.out.println(page.GetResult());

	}

}
