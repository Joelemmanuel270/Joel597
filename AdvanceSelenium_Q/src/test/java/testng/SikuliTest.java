package testng;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class SikuliTest {
	
	@Test
	public void priya() throws Throwable {
		Screen scr= new Screen();
		Pattern pt=new Pattern("C:\\Users\\joele\\OneDrive\\Desktop\\qspider\\start.png");
		
		scr.type(pt,"note");
		Thread.sleep(500);
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		pt=new Pattern("C:\\Users\\joele\\OneDrive\\Desktop\\qspider\\notepad.png");
		scr.type(pt,"priya is a mental by birth");
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_SHIFT);
		rob.keyPress(KeyEvent.VK_S);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_SHIFT);
		rob.keyRelease(KeyEvent.VK_S);
		
		Random ran=new Random();
		int n = ran.nextInt(1000);
		Thread.sleep(500);
		scr.type("priya"+n);
		
		
	}

}
