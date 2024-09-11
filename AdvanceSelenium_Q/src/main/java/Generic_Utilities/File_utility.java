package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_utility extends Excel_Utility{
	
	
	
	/**
	 * This method is used to get values from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Joel
	 */
	public String getPropertiesvalue(String key) throws Throwable {
		FileInputStream file=new FileInputStream("./src/test/resources/commonData1.properties.txt");
		Properties pro=new Properties();
		pro.load(file);
		String value = pro.getProperty(key);
		return value;

	}
}
