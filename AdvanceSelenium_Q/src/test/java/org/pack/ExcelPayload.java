package org.pack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelPayload {
	
	 FileInputStream excel;
	 Workbook workbook;
	 String s;
	 FileOutputStream fos ;
	 Random rand;
	 int val ;
	 
	 public ExcelPayload() {
		 
		rand=new Random();
		val = rand.nextInt(1000);
		s= "Sheet"+val;
			 
	}
	 
	 
	 public void excelFile() throws Throwable {
		 HSSFWorkbook wb = new HSSFWorkbook();   
			//creates an excel file at the specified location  
			fos = new FileOutputStream("C:\\Users\\joele\\OneDrive\\Desktop\\tele\\Book"+val+".xlsx");   
			System.out.println("Excel File has been created successfully.");   
			wb.write(fos); 
			wb.close();
			
			excel = new FileInputStream("C:\\Users\\joele\\OneDrive\\Desktop\\tele\\Book"+val+".xlsx");
			workbook = WorkbookFactory.create(excel);

	}
	 
	 public void excelFile(String[] medals) throws Throwable {
		
		 Sheet sheet = workbook.createSheet(s);
		 Row row = sheet.createRow(0);
		 for (int i = 0; i < medals.length; i++) {
				
				Cell cell = row.createCell(i);
				cell.setCellValue(medals[i]);
		
			}
		 
		 FileOutputStream fos = new FileOutputStream("C:\\Users\\joele\\OneDrive\\Desktop\\tele\\Book"+val+".xlsx");
		 workbook.write(fos);
	}
	
	public void excelFile(String[] medals, int countrycount) throws EncryptedDocumentException, IOException {
		
		
		Sheet sheet = workbook.getSheet(s);
		Row row = sheet.createRow(countrycount);

		for (int i = 0; i < medals.length; i++) {
			
			Cell cell = row.createCell(i);
			cell.setCellValue(medals[i]);
	
		}
		fos = new FileOutputStream("C:\\Users\\joele\\OneDrive\\Desktop\\tele\\Book"+val+".xlsx");
		workbook.write(fos);
		
		
	}
	
	
	public void bookClose() throws IOException {
		
		workbook.close();

	}
	
}