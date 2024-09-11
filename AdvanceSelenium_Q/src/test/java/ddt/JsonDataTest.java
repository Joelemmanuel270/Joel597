package ddt;

import java.io.File;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.*;

public class JsonDataTest { 
	
	@Test
	public void json() throws Throwable {
		
		File json=new File("./src\\test\\resources\\jsondata.json");
		
		ObjectMapper jsRead=new ObjectMapper();
		JsonNode tree = jsRead.readTree(json);
		String message = tree.get("message").asText();
		System.out.println(message);
		
	}

}
