package utilityPackage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance()
	{
		if (extent==null)
		{
			ExtentSparkReporter sparkReporter= new ExtentSparkReporter("test-output/ExtentReport.html");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setDocumentTitle("Automation Execution Report");
			sparkReporter.config().setReportName("Ivanti Automation Report");
			extent= new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Environment", "Stage");
			extent.setSystemInfo("Tester name", "Himanshu");
		}
		return extent;
	}
}
