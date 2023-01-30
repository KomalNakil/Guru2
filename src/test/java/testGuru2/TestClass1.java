package testGuru2;

import org.testng.annotations.Test;

import baseGuru2.BaseGuru2;
import pomGuru2.TVPage;
import pomGuru2.UserAccountPage;
import pomGuru2.homeGuruDemo;
import pomGuru2.mobilePageGuru2;
import pomGuru2.registrationPage;
import pomGuru2.shoppingCartPage;
import pomGuru2.sonyXperiaDetailPage;
import pomGuru2.wishListPage;
import utilityGuru2.utilityGuru;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestClass1 extends BaseGuru2{
	homeGuruDemo home;
	mobilePageGuru2 mobile;
	sonyXperiaDetailPage detail;
	shoppingCartPage cart;
	registrationPage register;
	UserAccountPage act;
	TVPage tv;
	wishListPage wish;
	
	@BeforeMethod
	  public void beforeLaunchURL() throws IOException {
		launchGuruDemoPage();
		home = new homeGuruDemo(driver);
		mobile = new mobilePageGuru2(driver);
		detail = new sonyXperiaDetailPage(driver);
		cart = new shoppingCartPage(driver);
		register = new registrationPage(driver);
		act = new UserAccountPage(driver);
		tv = new TVPage(driver);
		wish = new wishListPage(driver);
		
		
		home.clickOnMobileButton(driver);
		
		
	  }
	
	@Test
	  public void verifyTitle() throws IOException {
			driver.navigate().back();
		  Assert.assertEquals(utilityGuru.readPropertyFile(driver, "expectedHomePageTitle"), home.getTitleOfHomePage(driver), "TC Failed Home PAge Title not matched");
		  Assert.assertTrue(home.getTitle(driver));
		  home.clickOnMobileButton(driver);
		  Assert.assertEquals(utilityGuru.readPropertyFile(driver, "expectedMobilePageTitle"), mobile.getMobilePageTitle(driver), "TC Failed MobilePAge Title not matched");
		  mobile.selectSortByName(driver);
		  utilityGuru.ss(driver, "sortedByName");
	  }
	
  @Test
  public void verifyProductPriceFromDetailPage() throws IOException, InterruptedException { 
	  String price = mobile.getPriceOfSonyXperiaFromMobilePage(driver);
	  mobile.clickOnSonyXperiaImage(driver);
	  Assert.assertEquals(price, detail.getPriceOfSonyXperiaFromDetailPage(driver), "TC Failed as Mobile page and detail page price not matched" );
	  utilityGuru.ss(driver, "comparePrice");
  }
  
 @Test
 public void verifyErrorMsg() throws IOException {
	 mobile.clickOnAddToCartButtonSony(driver);
	 String expectedError = "* The maximum quantity allowed for purchase is 500.";
	 Assert.assertEquals(expectedError, cart.sendQuantityAndClickOnUpdate(driver));
	 String expectedCartMsg = "SHOPPING CART IS EMPTY";
	 Assert.assertEquals(expectedCartMsg, cart.clickOnEmptyCartAndVerifyMsg(driver));
	 utilityGuru.ss(driver, "CartVerification");
 }
 
 @Test
 public void compareTwoProducts1() throws InterruptedException
 { 
	 Assert.assertTrue(mobile.compareProd(driver),"TC failed returned False");
	 
 }
 
 @Test
 public void verifyCreateECommerceAct() throws InterruptedException, IOException
 { 
	 driver.navigate().back();
	 home.clickOnMyAccount(driver);
	 register.logintoAct(driver);
	 Assert.assertTrue(act.validateUserName(driver),"TC Failed as username not matched");
	 Assert.assertTrue(tv.verifyWishlist(driver) , "TC failed as item name not matched");
	 Assert.assertTrue(wish.verifySendWishList(driver), "TC failed as Wishlist not shared");
	 
 }
  
  @AfterMethod
  public void closeCurrentBrowser() {
	  closeGuruDemoPage();
  }

}
