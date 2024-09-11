package Generic_Utilities;

import java.util.Random;

public class Java_Utilities {
	

	
	/**
	 * This method is used to avoid Duplicates
	 * @return
	 * @author Joel
	 */
	public int getRandomNum() {
		Random ran=new Random();
		int d = ran.nextInt(1000);
		return d;
	}
}
