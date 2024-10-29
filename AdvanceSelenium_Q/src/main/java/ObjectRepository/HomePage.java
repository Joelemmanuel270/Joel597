package ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement AdminLink;
	
	@FindBy(css = "[href='index.php?module=Users&action=Logout']")
	private WebElement signOut;
	
	@FindBy(css = "[href='index.php?module=Products&action=index']" )
	private WebElement prdLink;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement more;
	
	public WebElement getPrdLink() {
		return prdLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getAdminLink() {
		return AdminLink;
	}

	public WebElement getClickOnSignOut() {
		return signOut;
	}
	
	/**
	 * this method is used to sign out from application
	 * @throws Throwable 
	 */
	 public void logOutFromApp()
	{	
//		 try {
//			Thread.sleep(200);
//		} catch (Throwable e) {
//			System.out.println("TimeError");
//		}
		 AdminLink.click();
	     signOut.click();
	    
	 }
	 
	 public void clickProductLink()
	 {
		 prdLink.click();
	 }


}
