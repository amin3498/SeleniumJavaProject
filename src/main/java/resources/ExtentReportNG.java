package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports extent = null;

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\extentreports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Test Engineer", "Mohammad Amin");
		return extent;
	}



}
