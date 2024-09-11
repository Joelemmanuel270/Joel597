package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {
	WebDriver driver;
	public CreatingNewCampaignPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTextfield;
	
	
	@FindBy(css = "[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(css = "[alt='Select']")
	private WebElement productAddButton;
	
	
	
	
	public WebElement getProductAddButton() {
		return productAddButton;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getCampaignNameTextfield() {
		return campaignNameTextfield;
	}
	
	
	
}
