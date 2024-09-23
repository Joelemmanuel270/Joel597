package testng;


import java.awt.event.KeyEvent;
import java.util.Random;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class SikuliTest  {
	
	@Test(groups = "priya")
	public void priya() throws Throwable {
		
		Bundle file=new Bundle();
		
		
		Screen scr= new Screen();
		String start = file.filePath("./src/test/resources/start.png");
		Pattern pt=new Pattern(start);
		
		scr.type(pt,"notepad");
		Thread.sleep(500);
		
		file.keyBoard(KeyEvent.VK_ENTER);

		String note = file.filePath("./src/test/resources/notepad.png");
		pt=new Pattern(note);
		scr.type(pt,"priya is a mental by birth");
		
		file.keyBoard(KeyEvent.VK_CONTROL);
		file.savefile();
		
		
		Random ran=new Random();
		int n = ran.nextInt(1000);
		Thread.sleep(500);
		scr.type("priya"+n);
		
		
	}
	
	@Test
	public void lusuPriya() {
		System.out.println("method name is correct ==> lusuPriya");

	}
	
	
	@Test
	public void priyaLusu() {
		System.out.println("method name is correct ==> priyaLusu");

	}

}
