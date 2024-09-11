package Generic_Utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class Excel_Utility extends Java_Utilities {
	
	
	
	
		/**
		 * This method is used to read the excel data in a cell
		 * @param Sheet
		 * @param rowNum
		 * @param cellNum
		 * @return
		 * @throws Throwable
		 * @author Joel
		 */
	public String getExcelData(String Sheet,int rowNum,int cellNum) throws Throwable {
		
		FileInputStream xl=new FileInputStream("C:\\Users\\joele\\OneDrive\\Desktop\\tele\\Book541.xlsx");
		Workbook excel= WorkbookFactory.create(xl);
		Sheet sheet = excel.getSheet(Sheet);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format=new DataFormatter();
		String CellValue = format.formatCellValue(cell);
		
		return CellValue;
	}
}
