package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class Webdriver_Utility extends File_utility{
	WebDriver driver;
	
	
	public Webdriver_Utility(WebDriver driver) {
		
		this.driver=driver;
	}

	
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public void FullScreenWindow() {
		driver.manage().window().fullscreen();
	}

	public void pageWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public void switchingWindows(String titlename) {

		Set<String> windowHandles1 = driver.getWindowHandles();
		Iterator<String> iterator1 = windowHandles1.iterator();
		
		while (iterator1.hasNext()) {
			String win = iterator1.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.contains(titlename)) {
				break;
			}
		}

	}

	
	
	
}
