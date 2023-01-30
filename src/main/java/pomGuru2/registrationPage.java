package pomGuru2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityGuru2.utilityGuru;

public class registrationPage {
	@FindBy (xpath= "//a[@class='button']") private WebElement createActButton;
	@FindBy (xpath = "//input[@title='Email Address']") private WebElement emailField;
	@FindBy (xpath = "//input[@title='Password']") private WebElement passwordField;
	@FindBy (xpath = "//button[@id='send2']") private WebElement loginButton;
	
	public registrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewAccount(WebDriver driver)
	{
		createActButton.click();
	}
	
	public void logintoAct(WebDriver driver) throws IOException
	{
		emailField.clear();
		emailField.sendKeys(utilityGuru.readPropertyFile(driver, "email"));
		passwordField.clear();
		passwordField.sendKeys(utilityGuru.readPropertyFile(driver, "pwd"));
		loginButton.click();
	}
}
