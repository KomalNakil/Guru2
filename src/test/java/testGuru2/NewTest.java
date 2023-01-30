package testGuru2;

import org.testng.annotations.Test;

import baseGuru2.BaseGuru2;
import pomGuru2.homeGuruDemo;
import pomGuru2.mobilePageGuru2;
import utilityGuru2.utilityGuru;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest extends BaseGuru2 {
	
	homeGuruDemo home;
	mobilePageGuru2 mobile;
	
	@BeforeClass
	  public void beforeLaunchURL() throws IOException {
		launchGuruDemoPage();
		home = new homeGuruDemo(driver);
		mobile = new mobilePageGuru2(driver);
		
	  }
 
//  @BeforeMethod
//  public void beforeMethod() {
//  }

  @Test
  public void verifyTitle() throws IOException {
	  Assert.assertEquals(utilityGuru.readPropertyFile(driver, "expectedHomePageTitle"), home.getTitleOfHomePage(driver), "TC Failed Home PAge Title not matched");
	  Assert.assertTrue(home.getTitle(driver));
	  home.clickOnMobileButton(driver);
	  Assert.assertEquals(utilityGuru.readPropertyFile(driver, "expectedMobilePageTitle"), mobile.getMobilePageTitle(driver), "TC Failed MobilePAge Title not matched");
	  mobile.selectSortByName(driver);
	  utilityGuru.ss(driver, "sortedByName");
  }
  
//  @AfterMethod
//  public void afterMethod() {
//  }

 

  @AfterClass
  public void closeCurrentBrowser() {
	  closeGuruDemoPage();
  }

}
