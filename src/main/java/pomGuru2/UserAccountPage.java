package pomGuru2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {
	@FindBy (xpath= "//strong[text()='Hello, K S D!']") private WebElement userName;
	@FindBy (xpath= "//a[text()='TV']") private WebElement TVButton;
	
	
	public UserAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUserName(WebDriver driver)
	{
		boolean un = userName.getText().contains("K S D");
		TVButton.click();
		return un;
	}
	
	

}
