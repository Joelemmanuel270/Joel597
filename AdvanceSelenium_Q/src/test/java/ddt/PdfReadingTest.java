package ddt;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class PdfReadingTest { 
	
	@Test
	public void main() throws Throwable {
		
		File fis=new File("C:/Users/joele/OneDrive/Documents/taizor.pdf");
		
		PDDocument doc = PDDocument.load(fis);
		PDFTextStripper pdfdata = new PDFTextStripper();
		String text = pdfdata.getText(doc);
		
		//System.out.println(text);
		int numberOfPages = doc.getNumberOfPages();
		System.out.println(numberOfPages);
		pdfdata.setStartPage(21);
		pdfdata.setEndPage(numberOfPages);
		text = pdfdata.getText(doc);
		System.out.println(text);
		
	
	}

}
