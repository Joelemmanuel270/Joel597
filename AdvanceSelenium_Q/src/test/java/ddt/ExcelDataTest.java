package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
	
public class ExcelDataTest {
	
	@Test
	public void data() throws Throwable {
		
		FileInputStream excel = new FileInputStream("C:\\Users\\joele\\OneDrive\\Desktop\\Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(excel);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(3);
		System.out.println(cell);
		
		//String stringCellValue = cell.getStringCellValue();
		//System.out.println(stringCellValue);
		
		DataFormatter format=new DataFormatter();
		String formatCellValue = format.formatCellValue(cell);
		System.out.println(formatCellValue);
		
		
		
		
		Cell cell2 = row.createCell(4);
		cell2.setCellValue("qspider");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\joele\\OneDrive\\Desktop\\Book1.xlsx");
		workbook.write(fos);
		System.out.println("written");
		
		
		
	}

}
