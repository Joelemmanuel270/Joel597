package Generic_Utilities;

import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{
ExtentTest test;
ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
//		System.out.println("----------im taking ScreenShot-----");
//		String screenshot=null;
//		try {
//			screenshot=Webdriver_Utility.takeScreenShot1(BassClass.driver,result.getMethod().getMethodName());
//		
//		} catch (Throwable e) {
//			
//			e.printStackTrace();
//		}
	//	test.addScreenCaptureFromPath(screenshot);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		Java_Utilities jlib = new Java_Utilities();
		int ranNum = jlib.getRandomNum();
	
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report"+ranNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Joel");
		
		//System configuration
		report=new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("platform", "window10");
		report.setSystemInfo("executedBy", "SHOBHA");
		report.setSystemInfo("Reviewed By", "Rathin");
		}

	@Override
	public void onFinish(ITestContext context)
	{
		report.flush();
		
	}

	
}