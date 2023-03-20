package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import base.TestBase;
import pages.AddContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtil;


public class TestOfAddContactPage extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	AddContactPage addcont;
	
	public TestOfAddContactPage() {  
		super();
	  }
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		openBrowser();
		lp = new LoginPage();		
		hp = lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		hp = new HomePage();
		addcont = new AddContactPage();
		addcont = hp.addcontact();
	
		
	}
	
    @Test
    public void verifyAddContactLable() {
    	String IconName = addcont.verifyAddContactLable();
    	System.out.println(IconName);
    	Assert.assertEquals(IconName, "Create New Contact");
    }
    
    @DataProvider
	public Object[][] getContactsTestData(){
		Object data[][] = null;
		try {
			data = TestUtil.getTestData("Contacts");
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider = "getContactsTestData")
	public void createNewContact(String firstName, String lastName, String position, String department) throws InterruptedException {
		hp.addcontact();		
		addcont.newContactDetails(firstName, lastName, position, department);
		
	}
    
  
    @AfterMethod
	public void tearDown() {
		closeBrowser();
	}
    
  
  
	
	
}

