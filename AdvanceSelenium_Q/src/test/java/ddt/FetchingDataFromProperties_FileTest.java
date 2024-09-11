package ddt;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FetchingDataFromProperties_FileTest {
	
	@Test
	public void Fetch() throws Throwable {
		
		WebDriver driver = new EdgeDriver();
	  	driver.manage().window().maximize();
		
		FileInputStream file1 = new FileInputStream("./src\\test\\resources\\commonData1.properties.txt");
		
		Properties pro = new Properties();
		pro.load(file1);
		
		String property = pro.getProperty("url");
		String property2 = pro.getProperty("username");
		String property3 = pro.getProperty("password");
		
		driver.get(property);
		System.out.println(property);
		System.out.println(property2);
		System.out.println(property3);
		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
