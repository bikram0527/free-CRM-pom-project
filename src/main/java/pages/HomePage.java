package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[@class='user-display']")
	public WebElement usernameLable;
	
	@FindBy(xpath = "//i[@class='users icon']")
	public WebElement contact;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	public WebElement contactIcon;
	
	
	@FindBy(xpath="(//div[@class='menu-item-wrapper'])[3]//button")
	WebElement addcontact;
	
	@FindBy(xpath = "//i[@class='calendar icon']")
	public WebElement calender;
	
	@FindBy(xpath = "//div[@class='header item']")
	public WebElement image;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyImage() {
		return image.isDisplayed();
	}
	
	public String verifyUsername() {
		return usernameLable.getText();		
	}
	
	public ContactPage clickonContacts() {
		contact.click();
		return new ContactPage();
	}
	
	public CalenderPage clickonCalender() {
		calender.click();
		return new CalenderPage();
	}
	
	public AddContactPage addcontact() throws InterruptedException  {
		contactIcon.click();
		Thread.sleep(3000);
		Actions builder = new Actions(driver);	 
		builder.moveToElement(contact).build().perform();
		addcontact.click();
		return new AddContactPage();
		
	}

	
	
	
	
	
	
	
}
