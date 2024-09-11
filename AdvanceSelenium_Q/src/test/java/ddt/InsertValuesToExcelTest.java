package ddt;

import java.io.*;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class InsertValuesToExcelTest {
	
	@Test
	public void value() throws Throwable {
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://flipkart.com/");
		//driver.findElement(By.name("q")).sendKeys("puma");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//a"));
		Thread.sleep(1000);
		
		
		FileInputStream excel = new FileInputStream("C:\\Users\\joele\\OneDrive\\Desktop\\Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(excel);
		Sheet sheet = workbook.getSheet("book1");
		
		for (int i = 0; i < elements.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(3);
			cell.setCellValue(elements.get(i).getAttribute("href"));
			System.out.println(elements.get(i).getText());
		}
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\joele\\OneDrive\\Desktop\\Book1.xlsx");
		workbook.write(fos);
		workbook.close();
		
		driver.quit();
		
		
		
	}
}
