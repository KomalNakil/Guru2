package baseGuru2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilityGuru2.utilityGuru;

public class BaseGuru2 {
	protected WebDriver driver;
	public void launchGuruDemoPage() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", utilityGuru.chromePath);
		driver = new ChromeDriver();
		driver.get(utilityGuru.readPropertyFile(driver,"url"));
		driver.manage().window().maximize();
		//Reporter.log("LAunching GuruDemoPage", true);
		utilityGuru.wait(driver, 100);
	}
	
	public void closeGuruDemoPage()
	{
		//Reporter.log("Closing GuruDemo Page", true);
		utilityGuru.wait(driver, 100);
		driver.quit();
		
	}

}
