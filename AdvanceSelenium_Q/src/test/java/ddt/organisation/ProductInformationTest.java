package ddt.organisation;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import Generic_Utilities.*;

public class ProductInformationTest extends BaseClass {
	
	@Test
	public void  ProductInformation() throws Throwable {

		Java_Utilities jutils = new Java_Utilities();
		int d = jutils.getRandomNum();


		driver.findElement(By.cssSelector("[href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.name("productname")).sendKeys("Mouse" + d);

		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();


	}

}
