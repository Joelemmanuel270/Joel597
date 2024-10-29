package ddt.organisation;


import org.openqa.selenium.*;
import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Generic_Utilities.Java_Utilities;
import ObjectRepository.HomePage;

public class CreateOrganisationTest extends BaseClass {
	
	@Test
	public  void CreateOrganisation() throws Throwable {

//		WebDriver driver = new ChromeDriver();
//
//		File_utility futils = new File_utility();
//		String USERNAME = futils.getPropertiesvalue("username");
//		String PASSWORD = futils.getPropertiesvalue("password");
//		String URL = futils.getPropertiesvalue("url");
//
//		driver.get(URL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME, Keys.TAB, PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

		Java_Utilities jutils = new Java_Utilities();
		int d = jutils.getRandomNum();

		driver.findElement(By.name("accountname")).sendKeys("Qspiders" + d);
		driver.findElement(By.id("phone")).sendKeys("9874028394");
		driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("(//input[@class=\"crmbutton small save\"])[2]")).click();
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
//		// logout
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
//
//		driver.findElement(By.cssSelector("[href='index.php?module=Users&action=Logout']")).click();
//		driver.quit();

	}
}
