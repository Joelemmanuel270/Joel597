package testng;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.ImagePath;

public class Bundle {
	
	
	/**
	 * this method is to set file path for Sikulix
	 * Specially when we pass location of a file in the working directory 
	 * @param path
	 * @return
	 */
	public String filePath(String path) {
		ImagePath.setBundlePath(path);
		String setpath = ImagePath.getBundlePath();
		
		return setpath;
	}
	
	/**
	 * this method is to send button click on keyboard
	 * @param vkey
	 */
	public void keyBoard(int vkey){
		try {
			Robot rob=new Robot();
			
			rob.keyPress(vkey);
			rob.keyRelease(vkey);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void savefile(){
		try {
			Robot rob=new Robot();
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_SHIFT);
			rob.keyPress(KeyEvent.VK_S);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_SHIFT);
			rob.keyRelease(KeyEvent.VK_S);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
