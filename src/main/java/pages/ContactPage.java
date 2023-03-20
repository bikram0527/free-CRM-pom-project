package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy (linkText = "Contacts")
	public WebElement cont;
	
	@FindBy (xpath = "//i[@class='users icon']")
	public WebElement contactpage;
	
	@FindBy (xpath = "//a[contains(text(),'inder kaur')]")
	public WebElement contactNames;
	
	
	public ContactPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public boolean contactLable() {
		return cont.isDisplayed();
		
	}
	
	public String selectContactByName(String name) {
	    return driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).getText();
	    
	}
	
	
	
	
		

}
