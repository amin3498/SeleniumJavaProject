package rubastFrameWorkPackage;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import resources.ExtentReportNG;

public class Listeners extends Base implements ITestListener{

	ExtentReports extent ;
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); //This will Make test Thread safe. 

	@Override
	public void onTestStart(ITestResult result) {
		extent = ExtentReportNG.getReportObject();
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, " Test Output is as expected");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;
		//Screenshot for test failer.
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e ) {

		}


		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
			//getScreenShotPath(testMethodName, driver);
		} catch(IOException e ) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test skiped unexpected");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
