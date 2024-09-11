package ddt.organisation;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.BassClass;
import Generic_Utilities.Webdriver_Utility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class ProductDeleteTest extends BassClass {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		HomePage homelinks=new HomePage(driver);
		
		
		Webdriver_Utility webutil=new Webdriver_Utility(driver);
		String USERNAME = webutil.getPropertiesvalue("username");
		String PASSWORD = webutil.getPropertiesvalue("password");
		String URL = webutil.getPropertiesvalue("url");

		
		int d = webutil.getRandomNum();
		String s = "Mouse" + d;
		
		
		driver.get(URL);
		
		//implicit wait
		webutil.pageWait();
		
		//login
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME, Keys.TAB, PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.cssSelector("[href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(s);
		
		
		
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Products&action=index\"]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='" + s + "']/../../td/input[@type='checkbox']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class=\"crmbutton small delete\"])[1]")).click();
		driver.switchTo().alert().accept();
		List<WebElement> products = driver.findElements(By.xpath("//a[@title=\"Products\"]"));
		int count=0;
		for (WebElement product : products) {
			String str = product.getText();
			if (str.contains(s)) {
				System.out.println("The product is deleted successfully");
				count++;
			}
		}
		if (count==0) {
			System.out.println("The product is not deleted");
		}
		

		// logout		
		homelinks.logOutFromApp();
		Thread.sleep(2000);
		driver.quit();

	}

}
