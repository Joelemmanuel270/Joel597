package ddt.organisation;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Generic_Utilities.*;
import ObjectRepository.*;

public class CampaignInformation2Test extends BassClass{
	
	@Test
	public void CampaignInformation2() {
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
		
		int d = web.getRandomNum();
		CreatingNewCampaignPage createCamp=new CreatingNewCampaignPage(driver);	
		createCamp.getCampaignNameTextfield().sendKeys("Robotrob"+d);
		createCamp.getProductAddButton().click();
		
		// Switching tab
		web.switchingWindows("Products&action");

		ProductsTab product=new ProductsTab(driver);
		product.getProductSearchTextField().sendKeys("mouse");
		product.getSearchNowButton().click();
		product.getSpecificProduct().click();
		
		// Switching tab
		web.switchingWindows("Campaigns&action");
		
		createCamp.getSaveButton().click();
		CampaignInformationPage campInfo=new CampaignInformationPage(driver);
		String text = campInfo.getcampaignNameVerify().getText();
		System.out.println(text); 
		
		
	}

}
