package ddt.organisation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Generic_Utilities.*;
import ObjectRepository.*;


public class CampaigInformationTest extends BassClass{
	
	
	@Test
	public static void CampaigInformation() {
		
		Webdriver_Utility web=new Webdriver_Utility(driver);
		
		//business logic starts
		HomePage home=new HomePage(driver);
		WebElement more = home.getMore();	
		Actions mouse = new Actions(driver);
		mouse.moveToElement(more).perform();
		
		MoreDropDownPage moreDrop =new MoreDropDownPage(driver);
		moreDrop.getCampaign().click();	
		CampaignPage camp = new CampaignPage(driver);
		camp.getCreateCampaign().click();
		
		
		CreatingNewCampaignPage createCamp=new CreatingNewCampaignPage(driver);	
		int d = web.getRandomNum();
		createCamp.getCampaignNameTextfield().sendKeys("Robotrob"+d);
		createCamp.getSaveButton().click();
		
		CampaignInformationPage campInfo= new CampaignInformationPage(driver);
		String text = campInfo.getcampaignNameVerify().getText();
		System.out.println(text);
		

	}

	

}
