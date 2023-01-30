package pomGuru2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityGuru2.utilityGuru;

public class homeGuruDemo {
	@FindBy (xpath = "//a[@class='level0 ']") private WebElement MobileButton;
	@FindBy (xpath = "//h2[contains(text(),'This is demo site ')]") private WebElement titleText;
	@FindBy (xpath = "//a[@class='skip-link skip-account']") private WebElement accountButton;
	@FindBy (xpath = "(//a[@title='My Account'])[1]") private WebElement myAccountButton;
	
	public homeGuruDemo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleOfHomePage(WebDriver driver)
	{
		utilityGuru.explicitWait(driver, MobileButton, 1000);
		String homePageTitle = driver.getTitle();
		System.out.println("Homepage Title = " +homePageTitle);
		return homePageTitle;
	}
	
	public boolean getTitle(WebDriver driver) throws IOException
	{
		String hpagetitle = titleText.getText();
		System.out.println(hpagetitle);
		boolean r = hpagetitle.contains(utilityGuru.readPropertyFile(driver,"exHomePageTitle"));
		return r;
	}
	
	public void clickOnMobileButton(WebDriver driver)
	{
		utilityGuru.wait(driver, 500);
		MobileButton.click();
		
	}
	
	public void clickOnMyAccount(WebDriver driver)
	{
		accountButton.click();
		myAccountButton.click();
	}

}
