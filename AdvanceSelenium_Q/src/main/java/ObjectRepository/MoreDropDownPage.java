package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreDropDownPage {
	
	WebDriver driver;
	public MoreDropDownPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Campaigns")
	private WebElement Campaign;

	public WebElement getCampaign() {
		return Campaign;
	}
	
	
}
