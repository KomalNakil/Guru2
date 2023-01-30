package utilityGuru2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;

public class utilityGuru {
	public static final String chromePath = "C:\\Testing Project\\chromedriver_win32\\chromedriver.exe";
	
	public static void wait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}
	
	public static void ss(WebDriver driver, String ssName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String S = RandomString.make(2);
		File dest = new File("C:\\Users\\Shreeyu\\Desktop\\Software Testing\\GuruSS\\guru"+S+ssName +".png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
	}
	
	public static String readExcel(WebDriver driver, int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myFile = new File("C:\\Users\\Shreeyu\\Desktop\\Software Testing\\GuruSS\\tc-guru.xlsx");
		String value = WorkbookFactory.create(myFile).getSheet("Sheet3").getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public static String readPropertyFile(WebDriver driver, String key) throws IOException
	{
		
				Properties prop = new Properties();
				FileInputStream myPropFile = new FileInputStream("C:\\Users\\Shreeyu\\eclipse-workspace\\GuruProj2\\config.properties");
				prop.load(myPropFile);
				String value = prop.getProperty(key);
				return value;
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, int wTime)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(wTime));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	

}
