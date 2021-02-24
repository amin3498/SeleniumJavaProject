package rubastFrameWorkPackage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPageObjectClass;
import resources.Base;

public class ValidateTitle extends Base {
	public  WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateTitle.class);
	
	//A, Method will Execute before any test start execution.
	@BeforeTest
	public void SetUpTest() throws Exception {
		//this will initialize the driver
		driver = initilizeDriver();
		log.info("Driver is initilize Successfully");
		//driver.get("http://www.qaclickacademy.com/");
		driver.get(prop.getProperty("url"));
	}
	
	@Test 
	public void basePage() throws Exception {	

		//driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		//A, method will create an object for page Object Class and through object we can call all method
		// present in the page object class and execute in test class. 
		LandingPage land = new LandingPage(driver);
		land.ClickPOPUP();
		String title = land.getTitle().getText();
		log.info("Page title Successfull");
		System.out.println(title);
		//Folloing code will validate the Title
		Assert.assertEquals("FEATURED COURSES", title);
		String contact = land.getContact().getText();
		Assert.assertTrue(land.getContact().isDisplayed());
		land.getLogin().click();

	}
	
	
	//A, method will execute after all test
	//A, method will execute after all test
	//A, method will execute after all test
	//A, method will execute after all test
	@AfterTest
	public void TearDownTest() {
		if(driver != null) {
			driver.close();
			//driver.quit();
		}
	}
	
}
