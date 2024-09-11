package org.pack;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class OlympicsTest extends ExcelPayload{
	String s="";
	String[] arr;
	String gold;
	String silver;
	String bronze;
	String total;
	String[] medals;
	static int countrycount=0;
	
	
	public OlympicsTest() {
		 super();
		 s="";
		 arr=new String[35];
		 medals=new String[6];
		 gold="";
		 silver="";
		 bronze="";
		 total="";
		 medals[0]="CountryName";
		 medals[1]="GoldMedals";
		 medals[2]="SilverMedals";
		 medals[3]="BronzeMedals";
		 medals[4]="TotalMedals";
		 
		 
		 for (int i = 0; i < arr.length; i++) {
				arr[i]=" ";
			}	
		
	}
	
	
	
	@Test
	public void Start() throws Throwable    {
		OlympicsTest run=new OlympicsTest();
		run.excelFile();
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/paris-2024/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		
		
		System.out.printf("%-40s%15s%15s%15s%15s\n", "CountryName","GoldMedals","SilverMedals","BronzeMedals","TotalMedals");
		run.excelFile(medals);
		
			do {
				try {
					s = driver.findElement(By.cssSelector("div[data-index='96']")).getText();
					run.parisOlymics(driver, run);
					
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					run.parisOlymics(driver, run);
					
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,1100)");
				}
			} while (s.isEmpty());
			
			
		System.out.println("\nTotal no of countries participated in Olymbics : "+countrycount);
		run.bookClose();
		Thread.sleep(5000);
		driver.quit();
	}

	public void parisOlymics(WebDriver driver,OlympicsTest run) throws Throwable {
		
		List<WebElement> country = driver.findElements(By.xpath("//span[@class='euzfwma5 emotion-srm-uu3d5n']"));
		for (int i = 0; i < country.size(); i++) {
			int count=0;
		 
			String countryName = country.get(i).getText();
			
			arr[i]=	countryName;
			medals[0]=countryName;
			
			
			for (String a : arr) {
				if (a.equals(countryName)) {
					count++;
				}
				
			}
			
			if(count==1) {
				
			medals[1]= driver.findElement(By.xpath("//span[text()=\""+medals[0]+"\"]/../..//span[@class='e1oix8v91 emotion-srm-19huvme'][1]")).getText();			
			medals[2] = driver.findElement(By.xpath("//span[text()=\""+medals[0]+"\"]/../..//span[@class='e1oix8v91 emotion-srm-19huvme'][2]")).getText();
			medals[3] =  driver.findElement(By.xpath("//span[text()=\""+medals[0]+"\"]/../..//span[@class='e1oix8v91 emotion-srm-19huvme'][3]")).getText();
			medals[4]= driver.findElement(By.xpath("//span[text()=\""+medals[0]+"\"]/../..//span[@class='e1oix8v91 emotion-srm-bnzwbp']")).getText();
			//System.out.printf("%-40s%12s%12s%15s%17s\n", medals[0], medals[1], medals[2],medals[3],medals[4]);
			countrycount++;
			
			run.excelFile(medals, countrycount);
										
			}		
		}
	}
	
	
}

