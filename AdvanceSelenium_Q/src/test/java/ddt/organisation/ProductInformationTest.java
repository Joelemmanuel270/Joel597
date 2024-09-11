package ddt.organisation;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Generic_Utilities.*;

public class ProductInformationTest extends BassClass {

	public static void main(String[] args) throws Throwable {

		File_utility futils = new File_utility();
		String USERNAME = futils.getPropertiesvalue("username");
		String PASSWORD = futils.getPropertiesvalue("password");
		String URL = futils.getPropertiesvalue("url");

		Java_Utilities jutils = new Java_Utilities();
		int d = jutils.getRandomNum();

		Excel_Utility exUtils = new Excel_Utility();
		String excelData = exUtils.getExcelData("Sheet158", 1, 0);
		System.out.println(excelData);

		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME, Keys.TAB, PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.cssSelector("[href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.name("productname")).sendKeys("Mouse" + d);

		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();

		// logout
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.cssSelector("[href='index.php?module=Users&action=Logout']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
