package pomGuru2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sonyXperiaDetailPage {
	@FindBy (xpath = "//span[@class='price']") private WebElement sonyXperiaPriceFromDetailPage;
	@FindBy (xpath = "//input[@class='input-text qty']") private WebElement quantityField;
	
	
	public sonyXperiaDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPriceOfSonyXperiaFromDetailPage(WebDriver driver)
	{
		String priceFromDetailPage = sonyXperiaPriceFromDetailPage.getText();
		System.out.println("price from detail page = " +priceFromDetailPage);
		return priceFromDetailPage;
		
	}
	
	public void sendQuantityAndClickOnUpdateButton(WebDriver driver)
	{
		quantityField.sendKeys("1000");
	}

}
