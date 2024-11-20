package Generic_Utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ObjectRepository.*;

public class BaseClass {
	
	public WebDriver driver;
	Webdriver_Utility wlib;
	protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
	@BeforeSuite
	public void BS() {
		System.out.println("DataBase Connection open");
	}

	@BeforeTest
	public void BT() {
		System.out.println("Parallel execution");
	}

	@BeforeClass
	public void BC() throws Throwable {
		
		String BROWSER="";
		File_utility fileb = new File_utility();
		try {
			BROWSER = System.getProperty("Browser");
			if (BROWSER.isEmpty()) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			e.getMessage();
			BROWSER = fileb.getPropertiesvalue("Browser");
		}
		
		
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new EdgeDriver();
		}
		wlib = new Webdriver_Utility(driver);

		System.out.println("Browser launched");
		drivers.set(driver);
		
	}

	@BeforeMethod
	public void BM() throws Throwable {
		
		wlib = new Webdriver_Utility(driver);
		//wlib.maximizeWindow();
		wlib.pageWait();

		// reading data from properties file
		String URL = wlib.getPropertiesvalue("url");
		String USERNAME = wlib.getPropertiesvalue("username");
		String PASSWORD = wlib.getPropertiesvalue("password");

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

	}

	@AfterMethod
	public void AM() {
		HomePage home = new HomePage(driver);
		home.logOutFromApp();
	}

	@AfterClass
	public void AC() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterTest
	public void AT() {
		System.out.println("Parallel execution done");
	}

	@AfterSuite
	public void AS() {
		System.out.println("Close DataBase Connection");
	}



}
