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
public class HomePageNavigation extends Base {
	public  WebDriver driver;//This driver use for Parallel execution
	public static Logger log = LogManager.getLogger(ValidateTitle.class);

	@BeforeTest
	public void SetUpTest() throws Exception {
		//A, method will initialize the driver.
		driver = initilizeDriver();
		log.info("Driver Initilized successfully");
		//driver.get("http://www.qaclickacademy.com/");
	}

	@Test (dataProvider = "getData")
	public void basePage(String username, String Password, String text) throws Exception {
		driver.get(prop.getProperty("url"));
		log.info("Navigate to the URL successfull");
		Thread.sleep(1000);
		//A, method will create an object for page Object Class and through object we can call all method
		// present in the page object class and execute in test class. 
		LandingPage land = new LandingPage(driver);
		String title = land.getTitle().getText();
		System.out.println(title);
		Assert.assertEquals("FEATURED COURSES", title);
		land.getLogin().click();

		LoginPageObjectClass login = new LoginPageObjectClass(driver);
		//log.getEmail().sendKeys("abc@qw.com");
		login.getEmail().sendKeys(username);
		log.info("Username validate successfully");
		Thread.sleep(1000);
		//log.getPassword().sendKeys("amin123457");
		login.getPassword().sendKeys(Password);
		log.info("Password validate successfully");
		System.out.println(text);
		Thread.sleep(1000);
		login.getLogIn().click();

	}
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object [3][3];
		data[0][0]="abc@qw.com";
		data[0][1]="amin123457";
		data[0][2]="Restricted user";

		data[1][0]="mamin@yahoo.com";
		data[1][1]="amin1234";
		data[1][2]="Non-Restricted user";

		data[2][0]="mamin3498@yahoo.com";
		data[2][1]="amin3498";
		data[2][2]="New User";
		return data;

	}

	@AfterTest
	public void TearDownTest() {
		if(driver != null) {
			driver.close();
		
		}
	}

}
