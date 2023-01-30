package pomGuru2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shoppingCartPage {
	@FindBy (xpath = "//span[text()='Update']") private WebElement updateButton;
	@FindBy (xpath = "(//input[@type='text'])[1]") private WebElement quantityField;
	@FindBy (xpath = "//p[@class='item-msg error']") private WebElement errorText;
	@FindBy (xpath = "//span[text()='Empty Cart']") private WebElement emptyCart;
	@FindBy (xpath = "//h1[text()='Shopping Cart is Empty']") private WebElement emptyCartMessage;
	
	public shoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String sendQuantityAndClickOnUpdate(WebDriver driver)
	{
		quantityField.clear();
		quantityField.sendKeys("1000");
		updateButton.click();
		String actualErrorText = errorText.getText();
		return actualErrorText;		
	}
	
	public String clickOnEmptyCartAndVerifyMsg(WebDriver driver)
	{
		emptyCart.click();
		String emptyCartText = emptyCartMessage.getText();
		return emptyCartText;
	}

}
