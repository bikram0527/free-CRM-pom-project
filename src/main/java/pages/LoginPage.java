package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy (xpath ="//input[@type='text']")
	public WebElement username;
	
	@FindBy (xpath ="//input[@type='password']")
	public WebElement password;
	
	@FindBy (xpath ="//div[@class='ui fluid large blue submit button']")
	public WebElement login;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage Login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
		return new HomePage();
	}
	
	
	

}
