package pomGuru2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityGuru2.utilityGuru;

public class wishListPage {
@FindBy (name = "emails") private WebElement emailField;
@FindBy (xpath = "//span[text()='Share Wishlist']") private WebElement shareWishListButton;	
@FindBy (xpath = "//span[text()='Your Wishlist has been shared.']")	private WebElement confirmShareWishlish;
@FindBy (xpath = "(//span[text()='Account'])[1]") private WebElement accountButton;
@FindBy (xpath = "//a[@title='Log Out']") private WebElement logoutButton;


public wishListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySendWishList(WebDriver driver) throws IOException
	{
		emailField.sendKeys(utilityGuru.readPropertyFile(driver, "email"));
		shareWishListButton.click();
		boolean r = confirmShareWishlish.getText().contains("Your Wishlist has been shared.");
		accountButton.click();
		logoutButton.click();
		return r;
			
	}

}
