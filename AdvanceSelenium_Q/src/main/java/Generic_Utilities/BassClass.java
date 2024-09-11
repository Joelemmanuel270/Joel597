package Generic_Utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import ObjectRepository.*;


public class BassClass {
	public static WebDriver driver;
	Webdriver_Utility wlib;
	
	
	
	//@BeforeSuite
	public void BS()
	{
		System.out.println("DataBase Connection open");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
	@BeforeClass
	public void BC() throws Throwable
	{
		
		wlib = new Webdriver_Utility(driver);
		String BROWSER = wlib.getPropertiesvalue("Browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		   	 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("safari"))
		{
			 driver=new SafariDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		wlib = new Webdriver_Utility(driver);
		System.gc();
		System.out.println("Browser launched");
	}
	
	@BeforeMethod
	public void BM() throws Throwable 
	{
		
		wlib = new Webdriver_Utility(driver);
		wlib.maximizeWindow();
		wlib.pageWait();
		
      //reading data from properties file	
		String URL = wlib.getPropertiesvalue("url");
		String USERNAME = wlib.getPropertiesvalue("username");
		String PASSWORD = wlib.getPropertiesvalue("password");

		driver.get(URL);		
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

	}
	
	@AfterMethod
	public void AM()
	{
		HomePage home = new HomePage(driver);
		 home.logOutFromApp();
	}
	
	@AfterClass
	public void AC()
	{
		driver.quit();
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("Parallel execution done");
	}
	
	//@AfterSuite
	public void AS()
	{
		System.out.println("Close DataBase Connection");
	}
}