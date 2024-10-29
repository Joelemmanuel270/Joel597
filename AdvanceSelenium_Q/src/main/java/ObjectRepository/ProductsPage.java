package ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public WebElement getCreateProductButton() {
		return createProductButton;
	}

	WebDriver driver;
	public ProductsPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductButton;
	
	
	
	
	public void clickCheckBox(String name) {
	
		driver.findElement(By.xpath("//a[text()='"+name+"']/../../td/input[@type='checkbox']"));

	}
	
}
