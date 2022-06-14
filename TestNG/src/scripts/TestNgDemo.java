package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgDemo {
  @Test
  public void f1() {
	  System.out.println("Executing F1");
  }
  
  @Test
  public void f2() {
	  System.out.println("Executing F2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Precondition for each script");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Postcondition for each script");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Precondition for each class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Postcondition for each class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Precondition for sanity tests");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Postcondition for sanity tests");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Precondition before test set");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Postcondition after test set");
  }

}
