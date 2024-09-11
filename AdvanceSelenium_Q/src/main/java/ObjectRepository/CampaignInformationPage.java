package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	WebDriver driver;
	public CampaignInformationPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement campaignNameVerify;

	public WebElement getcampaignNameVerify() {
		return campaignNameVerify;
	}
	
	
}
