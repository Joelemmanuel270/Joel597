package ddt.organisation;

import java.util.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import Generic_Utilities.*;
import ObjectRepository.*;

public class ProductDeleteTest extends BaseClass {
	
	@Test
	public void ProductDelete() throws Throwable {
		

		Webdriver_Utility webutil=new Webdriver_Utility(driver);
		int d = webutil.getRandomNum();
		String s = "Mouse" + d;
		
		HomePage home=new HomePage(driver);
		home.getPrdLink().click();
		
		ProductsPage pro=new ProductsPage(driver);
		pro.getCreateProductButton().click();
		
//		driver.findElement(By.cssSelector("[href='index.php?module=Products&action=index']")).click();
//		driver.findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();
		System.out.println(s);
		driver.findElement(By.name("productname")).sendKeys(s);

		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='"+ s +"']/../../td/input[@type='checkbox']")).click();
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
