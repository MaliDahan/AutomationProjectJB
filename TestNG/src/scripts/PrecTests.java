package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pages.PercentageCalcPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PrecTests {
	
	// local variables
	WebDriver driver;
	WebDriverWait wait;
	PercentageCalcPage page;
	
	
  @Test(dataProvider="DataForPrecCalc")
  public void PercCalc(String dataForInput1, String dataForInput2, String expected) {
	  try {
		  
		  	SoftAssert sa = new SoftAssert();
		  	page.EnterValueToField1(dataForInput1);
			page.EnterValueToField2(dataForInput2);
			sa.assertEquals(4, 4);
			page.ClickCalcButton();
			String actualResult=page.GetResult();
			
			
			sa.assertEquals(actualResult, expected);
			
			
			sa.assertAll();
		
			//Assert.assertEquals( expected, actualResult);
	  } catch(Exception e) {
		  System.out.println("Cannot execute PercCalc script due to " + e.getMessage());
	  }
	  	
  }
  
	/*
	 * @Test public void PercCalc20OutOf100() { page.EnterValueToField1("20");
	 * page.EnterValueToField2("100"); page.ClickCalcButton(); String
	 * actualResult=page.GetResult();
	 * 
	 * Assert.assertEquals("20% of 100 is not equals to 20", expected,
	 * actualResult); }
	 * 
	 * @Test public void PercCalc10OutOf1000() { page.EnterValueToField1("10");
	 * page.EnterValueToField2("1000"); page.ClickCalcButton(); String
	 * actualResult=page.GetResult();
	 * 
	 * Assert.assertEquals("10% of 1000 is not equals to 100", expected,
	 * actualResult); }
	 */
  @BeforeMethod
  public void beforeMethod() {
	  try {
		  
		  page.NavigateToPage();
		  
	  } catch(Exception e) {
		  System.out.println("Cannot navigate to page due to" + e.getMessage());
	  }
  }
	

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  
	  // do nothing
	  
  }

  @BeforeClass
  public void beforeClass() {
	  // init local variables
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbt\\Documents\\549147\\Selenium\\chromedriver_win32\\chromedriver.exe");   
		 driver =  new ChromeDriver(); 
		 wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		page = new PercentageCalcPage(driver, wait);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  
  @DataProvider(name = "DataForPrecCalc")
  public Object[][] createDataForPercCalc() {
   return new Object[][] {
     { "10", 	"200", 	"Result: 20" },
     { "2",	"100",	"Result: 2"},
     { "10",	"10",	"Result: 1"}
   };
  }


 
}
