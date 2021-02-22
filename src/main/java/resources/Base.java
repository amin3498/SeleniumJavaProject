package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{	
	public  WebDriver driver = null;
	public Properties prop = null;
	
	public WebDriver initilizeDriver() throws Exception {	
		//A, method will return the Project path.
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		
		//Following method will Integrate the Properties file with our Frame work.
		//Properties prop = new Properties();
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/Div/WorkSpace/RubastFrameWork/src/main/java/resources/data.properties");
		prop.load(fis);
		
		//A, Method will check the Browser available in Properties file and based on that it will execute the code. 
		String browserName = prop.getProperty("Browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",ProjectPath + "/AllSeleniumDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ProjectPath + "/AllSeleniumDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", ProjectPath + "/AllSeleniumDriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		else {
			throw new Exception("Browser not found");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		return driver;//This will return the driver, so we can use it from test class.
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
   
}
