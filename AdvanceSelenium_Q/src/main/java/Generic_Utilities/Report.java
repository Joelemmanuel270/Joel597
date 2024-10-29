package Generic_Utilities;

import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName());
		test.log(Status.PASS,result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(BaseClass.screenShot(BaseClass.sdriver,"priya"));
		
//		BaseClass.screenShot(result.getName())
//		test.addScreenCaptureFromPath(BassClass.screenShot(result.getName()));
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Vtiger");
		spark.config().setReportName("Joel");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Plateform", "windows 11");
		report.setSystemInfo("Executed By", "JOEL");
		report.setSystemInfo("Executed By", "PRIYA MAGESAN");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
