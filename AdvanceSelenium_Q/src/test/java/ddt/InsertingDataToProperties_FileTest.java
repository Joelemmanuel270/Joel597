package ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class InsertingDataToProperties_FileTest { 
	
	@Test
	public void exCel() throws IOException {
		
		FileOutputStream file = new FileOutputStream("./src/test/resources/Data1.properties");
		
		Properties pro = new Properties();
		pro.setProperty("url", "adjfoadnjdnv");
		pro.setProperty("name", "jo");
		pro.setProperty("address", "cross road");
		
		pro.store(file, "commet");
		
		
		
	}
}
