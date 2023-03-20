package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class TestOfLoginPage extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	
	public TestOfLoginPage() {  // make constructer of this bcoz super keyword will call parent class constructor
		super();
	  }
	
	@BeforeMethod
	public void setUp() {
		openBrowser();
		lp = new LoginPage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	
	@Test(priority = 1)
	public void checkLoginPageTitle() {
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginToFreeCrm() {
		hp = lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
