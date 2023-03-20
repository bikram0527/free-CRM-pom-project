package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class TestOfHomePage extends TestBase {
	
	
	LoginPage lp;
	HomePage hp;
	
	public TestOfHomePage() {  // make constructer of this bcoz super keyword will call parent class constructor
		super();
	  }
	
	@BeforeMethod
	public void setUp() {
		openBrowser();
		lp = new LoginPage();
		hp = lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		hp = new HomePage();
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String hTitle = hp.validateHomePageTitle();
		Assert.assertEquals(hTitle, "Cogmento CRM", "Homepage title did not match");
		}
	
	@Test(priority = 2)
	public  void verifyHomePageImage() {
		boolean flag = hp.verifyImage();
		Assert.assertTrue(flag);		
		}
	
	@Test(priority = 3)
	public void verifyHomePageUsername() {     
		String uName = hp.verifyUsername();
		Assert.assertEquals(uName, "Bikram Singh");
		}
	
		
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
