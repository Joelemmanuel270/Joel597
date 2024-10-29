package practice;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdvanceScenerio {
	
public static void main(String[] args) throws Throwable {
		
//		//Two Approaches
//		//*Keys Class----->Static methods
//		//*Robot Class---->Non Static Methods
//		
	WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.saucedemo.com/v1/");
//
//		//case1:-
//		WebElement UserNAme = driver.findElement(By.name("user-name"));
////		UserNAme.sendKeys("standard_user",Keys.TAB,"secret_sauce",Keys.ENTER);
//		
//		UserNAme.sendKeys("standard_user");
//		
//		Robot rob = new Robot();
//		 rob.keyPress(KeyEvent.VK_CONTROL);
//		 rob.keyPress(KeyEvent.VK_A);
//		 rob.keyRelease(KeyEvent.VK_CONTROL);
//		 rob.keyRelease(KeyEvent.VK_A);
//		 
//		Thread.sleep(1000);
//		 rob.keyPress(KeyEvent.VK_CONTROL);
//		 rob.keyPress(KeyEvent.VK_C);
//		 rob.keyRelease(KeyEvent.VK_CONTROL);
//		 rob.keyRelease(KeyEvent.VK_C);
//		 
//		Thread.sleep(1000);
//		 rob.keyPress(KeyEvent.VK_TAB);
//		 rob.keyRelease(KeyEvent.VK_TAB);
//		 
//		Thread.sleep(1000);
//		 rob.keyPress(KeyEvent.VK_CONTROL);
//		 rob.keyPress(KeyEvent.VK_V);
//		 rob.keyRelease(KeyEvent.VK_CONTROL);
//		 rob.keyRelease(KeyEvent.VK_V);
//		 
//		Thread.sleep(3000);
//		
//		
//		//new
//		driver.get("https://www.bigbasket.com");
//		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]"))
//		.sendKeys("Apples",Keys.ENTER);
//		Thread.sleep(3000);
//		
//		//new
		driver.get("https://www.saucedemo.com/v1/");
		Actions mouse=new Actions(driver);
		WebElement PASSWORD = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("btn_action"));
		WebElement USERNAME = driver.findElement(By.id("user-name"));
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(login));
		
		FluentWait wait1 = new FluentWait(driver);
		wait1.pollingEvery(Duration.ofSeconds(1));
		wait1.withTimeout(Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(login));
		
		
		login.click();

		
		mouse.sendKeys(USERNAME,"standard_user")
		.sendKeys(PASSWORD,"secret_sauce")
		.click(login).build().perform();
//
//	    driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
//	    WebElement drag = driver.findElement(By.id("draggable"));
//	    WebElement drop = driver.findElement(By.id("droppable"));
//	    Actions act = new Actions(driver);
//
//	    act.clickAndHold(drag).release(drop).perform();
//	
//	    act.dragAndDrop(drag, drop).perform();
	
//	Thread.sleep(2000);
//		driver.get("https://www.facebook.com");
//		
//	
//		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
//		Thread.sleep(2000);
//		
//		WebElement element = driver.findElement(By.xpath("//select[@aria-label=\"Day\"]"));
//		Select set=new Select(element);
//		set.selectByIndex(3);

//	Thread.sleep(2000);
//	
//	driver.get("https://demoqa.com/select-menu");
//		driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]")).click();
//		Select set1=new Select(element1);
//		set1.selectByIndex(3);
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(login));
//		
//		Robot rob = new Robot();
//		rob.keyPress(KeyEvent.VK_DOWN);
//		rob.keyRelease(KeyEvent.VK_DOWN);
//		
//		Thread.sleep(2000);
//        rob.keyPress(KeyEvent.VK_DOWN);
//		rob.keyRelease(KeyEvent.VK_DOWN);
//		
//		Thread.sleep(2000);
//		rob.keyPress(KeyEvent.VK_ENTER);
//		rob.keyRelease(KeyEvent.VK_ENTER);
		
		}



//div[@class=' css-2613qy-menu']
}
