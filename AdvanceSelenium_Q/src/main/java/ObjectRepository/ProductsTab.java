package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsTab {

	WebDriver driver;
	public ProductsTab(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement ProductSearchTextField;
	
	@FindBy(css="[type='button']")
	private WebElement SearchNowButton;
	
	@FindBy(xpath="//a[text()='Mouse824']")
	private WebElement SpecificProduct;
	
	public WebElement getSpecificProduct() {
		return SpecificProduct;
	}
	
	public WebElement getSearchNowButton() {
		return SearchNowButton;
	}
	
	public WebElement getProductSearchTextField() {
		return ProductSearchTextField;
	}
	
}
