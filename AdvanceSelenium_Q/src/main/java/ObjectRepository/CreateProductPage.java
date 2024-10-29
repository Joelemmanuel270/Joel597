package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProductPage{
		
	@FindBy(css = "[href='index.php?module=Products&action=index']" )
	private WebElement productbutton;
	
	
	
}
