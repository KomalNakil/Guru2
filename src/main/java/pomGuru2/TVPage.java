package pomGuru2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVPage {
	@FindBy(xpath = "(//a[text()='Add to Wishlist'])[1]") private WebElement wishlistTab;
	@FindBy (xpath = "//span[contains(text(),'LG LCD has been added ')]") private WebElement confirmWishList;
	@FindBy (xpath = "//span[text()='Share Wishlist']") private WebElement shareWishlist;
	
	public TVPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyWishlist(WebDriver driver)
	{
		wishlistTab.click();
		 boolean wish = confirmWishList.getText().contains("LG LCD has been added");
		shareWishlist.click();
		return wish;
	}

}
