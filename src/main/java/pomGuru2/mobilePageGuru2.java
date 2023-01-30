package pomGuru2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilityGuru2.utilityGuru;

public class mobilePageGuru2 {
	
	@FindBy (xpath = "//select[@title='Sort By']") private WebElement sortByDropDown;
	@FindBy (xpath = "(//span[@class='price'])[4]") private WebElement sonyXperiaPrice;
	@FindBy (id = "product-collection-image-1") private WebElement sonyXperiaImage;
	@FindBy (xpath = "(//span[text()='Add to Cart'])[2]") private WebElement addToCartSony;
	@FindBy (xpath = "(//a[@class='link-compare'])[3]") private WebElement compareSony;
	@FindBy (xpath = "(//a[@class='link-compare'])[1]") private WebElement compareIPhone;
	@FindBy (xpath ="//span[text()='Compare']") private WebElement compareButton;
	@FindBy (xpath ="//h2/a[@title='IPhone']") private WebElement iphone;
	@FindBy (xpath ="//h2/a[@title='Sony Xperia']") private WebElement sony;
	@FindBy (xpath ="(//a[@title='IPhone'])[2]") private WebElement popupIphone;
	@FindBy (xpath ="(//a[@title='Sony Xperia'])[2]") private WebElement popupSony;
	@FindBy (xpath = "//span[text()='Close Window']") private WebElement popupClose;
	
	public mobilePageGuru2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getMobilePageTitle(WebDriver driver)
	{
		utilityGuru.wait(driver, 500);
		String mobilePageTitle = driver.getTitle();
		System.out.println("Mobile Page Title = "+mobilePageTitle);
		return mobilePageTitle;
	}
	
	public void selectSortByName(WebDriver driver)
	{
		Select s = new Select(sortByDropDown);
		s.selectByVisibleText("Name");
	}
	
	public String getPriceOfSonyXperiaFromMobilePage(WebDriver driver) throws InterruptedException
	{
		//utilityGuru.explicitWait(driver, sonyXperiaImage, 5000);
		//Thread.sleep(5000);
		String priceFromMobilePage = sonyXperiaPrice.getText();
		System.out.println("PRice of Sony Experia on Mobile Page : " +priceFromMobilePage);
		return priceFromMobilePage;
	}
	
	public void clickOnSonyXperiaImage(WebDriver driver)
	{
		utilityGuru.explicitWait(driver, sonyXperiaImage, 5000);
		sonyXperiaImage.click();
	}
	
	public void clickOnAddToCartButtonSony(WebDriver driver)
	{
		addToCartSony.click();
	}
	
//	public void comapareTWoProducts(WebDriver driver)
//	{
//		compareSony.click();
//		compareIPhone.click();
//		compareButton.click();
//	}
//	
//	public String getPhoneName1(WebDriver driver)
//	{
//		 return iphone.getText();
//		
//	}
//	
//	public String getPhoneName2(WebDriver driver)
//	{
//		return sony.getText();
//		
//	}
//	
//	public String popHandling(WebDriver driver) throws InterruptedException
//	{
//		Set<String> allWinID = driver.getWindowHandles();
//		for(String i : allWinID)
//		{
//			System.out.println(i);
//		}
//		Thread.sleep(3000);
//		Iterator<String> it = allWinID.iterator();
//		String mainWinID = it.next();
//		String childWinId = it.next();
//		driver.switchTo().window(childWinId);
//		return mainWinID;
//	}
//	
//	public String getPopupP1(WebDriver driver)
//	{
//		return popupIphone.getText();
//	}
//	
//	public String getPopupP2(WebDriver driver)
//	{
//		return popupSony.getText();
//	}
//	
//	public void closePopup(WebDriver driver) throws InterruptedException
//	{
//		Thread.sleep(3000);
//		popupClose.click();
//		String mainID = popHandling(driver);
//		driver.switchTo().window(mainID);
//		
//	}
//	
	public boolean compareProd(WebDriver driver) throws InterruptedException
	{
		String phone1 = iphone.getText();
		System.out.println(phone1);
		String phone2 = sony.getText();
		System.out.println(phone2);
		compareSony.click();
		compareIPhone.click();
		compareButton.click();
		Set<String> allWinID = driver.getWindowHandles();
		for(String i : allWinID)
		{
			System.out.println(i);
		}
		Thread.sleep(3000);
		Iterator<String> it = allWinID.iterator();
		String mainWinID = it.next();
		String childWinId = it.next();
		driver.switchTo().window(childWinId);
		String popPhone1 = popupIphone.getText();
		System.out.println(popPhone1);
		String popPhone2 = popupSony.getText();
		System.out.println(popPhone2);
		Thread.sleep(3000);
		popupClose.click();	
		System.out.println("closed browser");
		driver.switchTo().window(mainWinID);
		System.out.println("back to window");
		if(phone1.equalsIgnoreCase(popPhone1) && phone2.equalsIgnoreCase(popPhone2))
		{
			return true;
		}
		return false;
	}

}
