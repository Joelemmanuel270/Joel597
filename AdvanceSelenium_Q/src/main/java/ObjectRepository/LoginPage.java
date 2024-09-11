package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "user_name")
	private WebElement UserTextField;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//BusinessLogics
	
	public void loginToApp(String USERNAME, String PASSWORD) {
					
		UserTextField.sendKeys(USERNAME, Keys.TAB, PASSWORD);
		LoginButton.click();
	}
	
	
}
