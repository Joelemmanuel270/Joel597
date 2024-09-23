package ddt.organisation;

import java.util.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import Generic_Utilities.BassClass;
import Generic_Utilities.Webdriver_Utility;

public class ProductDeleteTest extends BassClass {
	
	@Test
	public void ProductDelete() throws Throwable {
		

		Webdriver_Utility webutil=new Webdriver_Utility(driver);
		int d = webutil.getRandomNum();
		String s = "Mouse" + d;

		
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
		


	}

}
