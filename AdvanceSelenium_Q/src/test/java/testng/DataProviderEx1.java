package testng;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.*;

public class DataProviderEx1 {
	
	Object[][] objarr=new Object[92][5];
	
	@Test(dataProvider="array")
	public void joel(String country, String gold, String silver, String bronze,String total) {
		
		System.out.println("country name "+ country+" and "+gold+" and "+silver+" and "+bronze+" and "+total);	
		
	}

	
	
	@DataProvider
	public Object[][] array() {
		
		Object[][] obj=objarr;
		return obj;
		
	}
	
	
	@BeforeMethod
	public void Excel() throws Throwable {
		DataFormatter format=new DataFormatter();
		
		FileInputStream fis =new FileInputStream("C:\\Users\\joele\\OneDrive\\Desktop\\tele\\Book72.xlsx");
		Workbook book = WorkbookFactory.create(fis);
				
		Sheet sheet = book.getSheet("Sheet72");
		for (int i = 0; i < 92; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < 5; j++) {
				Cell cell = row.getCell(j);
				String formatCellValue = format.formatCellValue(cell);
				objarr[i][j]=formatCellValue;
			}
		}	
		

	}
}
