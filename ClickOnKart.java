import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClickOnKart {
	

	public ClickOnKart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
		
		
	}
	private WebDriver driver;
	
	
}
