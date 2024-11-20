package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener {
	
	private static ExtentReports report;
	private ThreadLocal<ExtentTest> thread =new ThreadLocal<>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		thread.get().log(Status.PASS, result.getMethod().getMethodName());
		thread.get().log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest Test = thread.get();
		Test.log(Status.FAIL, result.getMethod().getMethodName());
		Test.log(Status.FAIL, result.getThrowable());
		//WebDriver driver=(WebDriver)result.getTestContext().getAttribute("Browser");

		System.out.println("-----im taking ScreenShot-----");
		WebDriver driver = BaseClass.drivers.get();
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		File screenshotAs = shot.getScreenshotAs(OutputType.FILE);
		String methodName = result.getMethod().getMethodName();
		File target = new File("./Screenshot/"+methodName+".png");
		
		try {
			FileUtils.copyFile(screenshotAs, target);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}

		Test.addScreenCaptureFromPath(target.getAbsolutePath());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		thread.get().log(Status.SKIP, result.getMethod().getMethodName());
		thread.get().log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {

		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Joel");

		// System configuration
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "window10");
		report.setSystemInfo("executedBy", "SHOBHA");
		report.setSystemInfo("Reviewed By", "Rathin");
	}

	@Override
	public void onFinish(ITestContext context) {
		//Flush method ---->it will erase the previous data on the report and create a new report
		report.flush();

	}

}