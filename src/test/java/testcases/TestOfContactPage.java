package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;

public class TestOfContactPage extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactPage cp;
	
	public TestOfContactPage() {
		super();
		}
	@BeforeMethod
	public void setUp() {
		openBrowser();
		lp = new LoginPage();
		hp = new HomePage();
		cp = new ContactPage();
		
		hp = lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		cp = hp.clickonContacts();		
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	
	@Test(priority = 1)
	public void verifyContactLableDisplayed() {
		Assert.assertTrue(cp.contactLable());   
	}
	
	@Test(priority = 2)
	public void verifyContactLink() {
			hp.clickonContacts();
		}
	
	//@Test(priority = 3)
	public void SelectSingleContactName() {
		cp.selectContactByName("inder kaur");
		   //Assert.assertEquals(cName, cName, cName);
	}
	
	
	
	
	}


